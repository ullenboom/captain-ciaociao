package com.tutego.exercise.jdbc;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//tag::solution-entity[]
class Pirate {
  public final Long id;
  public final String nickname;
  public final String email;
  public final int swordLength;
  public final LocalDate birthdate;
  public final String description;

  public Pirate( Long id, String nickname, String email, int swordLength,
                 LocalDate birthdate, String description ) {
    this.id = id;
    this.nickname = nickname;
    this.email = email;
    this.swordLength = swordLength;
    this.birthdate = birthdate;
    this.description = description;
  }

  @Override public String toString() {
    return "Pirate[" + "id=" + id + ", nickname='" + nickname + '\''
           + ", email='" + email + '\'' + ", swordLength=" + swordLength
           + ", birthdate=" + birthdate + ", description='" + description + '\'' + ']';
  }
}
//end::solution-entity[]

//tag::solution-UncheckedSqlException[]
class DataAccessException extends RuntimeException {
  public DataAccessException( Throwable cause ) { super( cause ); }
  public DataAccessException( String message ) { super( message ); }
}
//end::solution-UncheckedSqlException[]

//tag::solution-a1[]
class PirateRepository {

  private static final String SQL_SELECT_ALL =
   "SELECT id, nickname, email, swordlength, birthdate, description FROM Pirate";
  private static final String SQL_SELECT_BY_ID =
   "SELECT id, nickname, email, swordlength, birthdate, description FROM Pirate WHERE id=?";
  private static final String SQL_INSERT =
   "INSERT INTO Pirate (nickname, email, swordlength, birthdate, description) " +
   "VALUES (?, ?, ?, ?, ?)";
  private static final String SQL_UPDATE =
   "UPDATE Pirate SET nickname=?, email=?, swordlength=?, birthdate=?, description=? " +
   "WHERE id=?";

  private final String jdbcUrl;

  public PirateRepository( String jdbcUrl ) {
    this.jdbcUrl = jdbcUrl;
  }
  //end::solution-a1[]

  //tag::solution-findAll[]
  public List<Pirate> findAll() {
    try ( Connection connection = DriverManager.getConnection( jdbcUrl );
          Statement  statement  = connection.createStatement();
          ResultSet  resultSet  = statement.executeQuery( SQL_SELECT_ALL ) ) {
      List<Pirate> result = new ArrayList<>();
      while ( resultSet.next() )
        result.add( mapRow( resultSet ) );
      return result;
    }
    catch ( SQLException e ) {
      throw new DataAccessException( e );
    }
  }
  //end::solution-findAll[]

  //tag::solution-findById[]
  public Optional<Pirate> findById( long id ) {
    try ( Connection connection = DriverManager.getConnection( jdbcUrl );
          PreparedStatement prepStatement = connection.prepareStatement(SQL_SELECT_BY_ID) ) {
      prepStatement.setLong( 1, id );
      ResultSet resultSet = prepStatement.executeQuery();
      return resultSet.next() ? Optional.of( mapRow( resultSet ) ) : Optional.empty();
    }
    catch ( SQLException e ) {
      throw new DataAccessException( e );
    }
  }
  //end::solution-findById[]

  //tag::solution-save[]
  public Pirate save( Pirate pirate ) {
    try ( Connection connection = DriverManager.getConnection( jdbcUrl ) ) {
      return pirate.id == null ? saveInsert( connection, pirate )
                               : saveUpdate( connection, pirate );
    }
    catch ( SQLException e ) {
      throw new DataAccessException( e );
    }
  }

  private Pirate saveInsert( Connection connection, Pirate pirate ) throws SQLException {
    try ( PreparedStatement prepStatement = connection.prepareStatement(
                                              SQL_INSERT, Statement.RETURN_GENERATED_KEYS ) ) {
      prepStatement.setString( 1, pirate.nickname );
      prepStatement.setString( 2, pirate.email );
      prepStatement.setInt(    3, pirate.swordLength );
      prepStatement.setDate(   4, Date.valueOf( pirate.birthdate ) );
      prepStatement.setObject( 5, pirate.description );
      prepStatement.executeUpdate();

      ResultSet generatedKeys = prepStatement.getGeneratedKeys();
      if ( generatedKeys.next() )
        return new Pirate( generatedKeys.getLong( 1 ), pirate.nickname, pirate.email,
                           pirate.swordLength, pirate.birthdate, pirate.description );
      throw new DataAccessException( "Could not retrieve auto-generated key for " + pirate );
    }
  }

  private Pirate saveUpdate( Connection connection, Pirate pirate ) throws SQLException {
    try ( PreparedStatement prepStatement = connection.prepareStatement( SQL_UPDATE ) ) {
      prepStatement.setString( 1, pirate.nickname );
      prepStatement.setString( 2, pirate.email );
      prepStatement.setInt(    3, pirate.swordLength );
      prepStatement.setDate(   4, Date.valueOf( pirate.birthdate ) );
      prepStatement.setObject( 5, pirate.description );
      prepStatement.setLong(   6, pirate.id );  // UPDATE Pirate SET ... WHERE id=?
      prepStatement.executeUpdate();
      return pirate;
    }
  }
  //end::solution-save[]

  //tag::solution-mapRow[]
  private static Pirate mapRow( ResultSet resultSet ) throws SQLException {
    return new Pirate( resultSet.getLong(   /* id */          1 ),
                       resultSet.getString( /* nickname */    2 ),
                       resultSet.getString( /* email */       3 ),
                       resultSet.getInt(    /* swordLength */ 4 ),
                       resultSet.getDate(   /* birthdate */   5 ).toLocalDate(),
                       resultSet.getString( /* description */ 6 ) );
  }
  //end::solution-mapRow[]

  //tag::solution-a2[]
  // ...
}
//end::solution-a2[]

//end::solution-c[]

public class PirateRepositoryDemo {
  public static void main( String[] args ) {
    CreateTable.main( args );
    //tag::example[]
    PirateRepository pirates = new PirateRepository( "jdbc:h2:./pirates-dating" );
    pirates.findAll().forEach( System.out::println );
    System.out.println( pirates.findById( 1L ) );
    System.out.println( pirates.findById( -1111L ) );
    Pirate newPirate = new Pirate(
        null, "BachelorsDelight", "GoldenFleece@RoyalFortune.firm", 15,
        LocalDate.of( 1972, 8, 13 ), "Best Sea Clit" );
    Pirate savedPirate = pirates.save( newPirate );
    System.out.println( savedPirate );
    Pirate updatedPirate = new Pirate(
        savedPirate.id, savedPirate.nickname, savedPirate.email,
        savedPirate.swordLength + 1, savedPirate.birthdate, savedPirate.description );
    pirates.save( updatedPirate );
    pirates.findAll().forEach( System.out::println );
    //end::example[]
  }
}