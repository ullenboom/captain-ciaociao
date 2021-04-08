
package com.tutego.exercise.xml.joke;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="flags"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="nsfw" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="religious" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="political" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="racist" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="sexist" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="setup" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="delivery" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="error" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "category",
    "type",
    "flags",
    "setup",
    "delivery",
    "id",
    "error"
})
@XmlRootElement(name = "data")
public class Data {

    @XmlElement(required = true)
    protected String category;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected Data.Flags flags;
    @XmlElement(required = true)
    protected String setup;
    @XmlElement(required = true)
    protected String delivery;
    protected int id;
    @XmlElement(required = true)
    protected String error;

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the flags property.
     * 
     * @return
     *     possible object is
     *     {@link Data.Flags }
     *     
     */
    public Data.Flags getFlags() {
        return flags;
    }

    /**
     * Sets the value of the flags property.
     * 
     * @param value
     *     allowed object is
     *     {@link Data.Flags }
     *     
     */
    public void setFlags(Data.Flags value) {
        this.flags = value;
    }

    /**
     * Gets the value of the setup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSetup() {
        return setup;
    }

    /**
     * Sets the value of the setup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSetup(String value) {
        this.setup = value;
    }

    /**
     * Gets the value of the delivery property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelivery() {
        return delivery;
    }

    /**
     * Sets the value of the delivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelivery(String value) {
        this.delivery = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setError(String value) {
        this.error = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="nsfw" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="religious" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="political" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="racist" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="sexist" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "nsfw",
        "religious",
        "political",
        "racist",
        "sexist"
    })
    public static class Flags {

        protected boolean nsfw;
        protected boolean religious;
        protected boolean political;
        protected boolean racist;
        protected boolean sexist;

        /**
         * Gets the value of the nsfw property.
         * 
         */
        public boolean isNsfw() {
            return nsfw;
        }

        /**
         * Sets the value of the nsfw property.
         * 
         */
        public void setNsfw(boolean value) {
            this.nsfw = value;
        }

        /**
         * Gets the value of the religious property.
         * 
         */
        public boolean isReligious() {
            return religious;
        }

        /**
         * Sets the value of the religious property.
         * 
         */
        public void setReligious(boolean value) {
            this.religious = value;
        }

        /**
         * Gets the value of the political property.
         * 
         */
        public boolean isPolitical() {
            return political;
        }

        /**
         * Sets the value of the political property.
         * 
         */
        public void setPolitical(boolean value) {
            this.political = value;
        }

        /**
         * Gets the value of the racist property.
         * 
         */
        public boolean isRacist() {
            return racist;
        }

        /**
         * Sets the value of the racist property.
         * 
         */
        public void setRacist(boolean value) {
            this.racist = value;
        }

        /**
         * Gets the value of the sexist property.
         * 
         */
        public boolean isSexist() {
            return sexist;
        }

        /**
         * Sets the value of the sexist property.
         * 
         */
        public void setSexist(boolean value) {
            this.sexist = value;
        }

    }

}
