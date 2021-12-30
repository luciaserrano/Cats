package com.example.cats.clases;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Breeds implements Parcelable {

    @SerializedName("adaptability")
    @Expose
    private Integer adaptability;
    @SerializedName("affection_level")
    @Expose
    private Integer affectionLevel;
    @SerializedName("alt_names")
    @Expose
    private String altNames;
    @SerializedName("cfa_url")
    @Expose
    private String cfaUrl;
    @SerializedName("child_friendly")
    @Expose
    private Integer childFriendly;
    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("country_codes")
    @Expose
    private String countryCodes;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("dog_friendly")
    @Expose
    private Integer dogFriendly;
    @SerializedName("energy_level")
    @Expose
    private Integer energyLevel;
    @SerializedName("experimental")
    @Expose
    private Integer experimental;
    @SerializedName("grooming")
    @Expose
    private Integer grooming;
    @SerializedName("hairless")
    @Expose
    private Integer hairless;
    @SerializedName("health_issues")
    @Expose
    private Integer healthIssues;
    @SerializedName("hypoallergenic")
    @Expose
    private Integer hypoallergenic;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("indoor")
    @Expose
    private Integer indoor;
    @SerializedName("intelligence")
    @Expose
    private Integer intelligence;
    @SerializedName("lap")
    @Expose
    private Integer lap;
    @SerializedName("life_span")
    @Expose
    private String lifeSpan;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("natural")
    @Expose
    private Integer natural;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("rare")
    @Expose
    private Integer rare;
    @SerializedName("reference_image_id")
    @Expose
    private String referenceImageId;
    @SerializedName("rex")
    @Expose
    private Integer rex;
    @SerializedName("shedding_level")
    @Expose
    private Integer sheddingLevel;
    @SerializedName("short_legs")
    @Expose
    private Integer shortLegs;
    @SerializedName("social_needs")
    @Expose
    private Integer socialNeeds;
    @SerializedName("stranger_friendly")
    @Expose
    private Integer strangerFriendly;
    @SerializedName("suppressed_tail")
    @Expose
    private Integer suppressedTail;
    @SerializedName("temperament")
    @Expose
    private String temperament;
    @SerializedName("vcahospitals_url")
    @Expose
    private String vcahospitalsUrl;
    @SerializedName("vetstreet_url")
    @Expose
    private String vetstreetUrl;
    @SerializedName("vocalisation")
    @Expose
    private Integer vocalisation;
    @SerializedName("weight")
    @Expose
    private Weight weight;
    @SerializedName("wikipedia_url")
    @Expose
    private String wikipediaUrl;

    /**
     * No args constructor for use in serialization
     *
     */
    public Breeds() {
    }

    /**
     *
     * @param altNames
     * @param childFriendly
     * @param origin
     * @param description
     * @param experimental
     * @param cfaUrl
     * @param suppressedTail
     * @param lifeSpan
     * @param energyLevel
     * @param countryCode
     * @param rare
     * @param socialNeeds
     * @param lap
     * @param id
     * @param shortLegs
     * @param affectionLevel
     * @param image
     * @param natural
     * @param rex
     * @param sheddingLevel
     * @param vcahospitalsUrl
     * @param hairless
     * @param vetstreetUrl
     * @param weight
     * @param adaptability
     * @param vocalisation
     * @param intelligence
     * @param wikipediaUrl
     * @param strangerFriendly
     * @param countryCodes
     * @param healthIssues
     * @param temperament
     * @param grooming
     * @param hypoallergenic
     * @param name
     * @param dogFriendly
     * @param indoor
     * @param referenceImageId
     */
    public Breeds(Integer adaptability, Integer affectionLevel, String altNames, String cfaUrl, Integer childFriendly, String countryCode, String countryCodes, String description, Integer dogFriendly, Integer energyLevel, Integer experimental, Integer grooming, Integer hairless, Integer healthIssues, Integer hypoallergenic, String id, Image image, Integer indoor, Integer intelligence, Integer lap, String lifeSpan, String name, Integer natural, String origin, Integer rare, String referenceImageId, Integer rex, Integer sheddingLevel, Integer shortLegs, Integer socialNeeds, Integer strangerFriendly, Integer suppressedTail, String temperament, String vcahospitalsUrl, String vetstreetUrl, Integer vocalisation, Weight weight, String wikipediaUrl) {
        super();
        this.adaptability = adaptability;
        this.affectionLevel = affectionLevel;
        this.altNames = altNames;
        this.cfaUrl = cfaUrl;
        this.childFriendly = childFriendly;
        this.countryCode = countryCode;
        this.countryCodes = countryCodes;
        this.description = description;
        this.dogFriendly = dogFriendly;
        this.energyLevel = energyLevel;
        this.experimental = experimental;
        this.grooming = grooming;
        this.hairless = hairless;
        this.healthIssues = healthIssues;
        this.hypoallergenic = hypoallergenic;
        this.id = id;
        this.image = image;
        this.indoor = indoor;
        this.intelligence = intelligence;
        this.lap = lap;
        this.lifeSpan = lifeSpan;
        this.name = name;
        this.natural = natural;
        this.origin = origin;
        this.rare = rare;
        this.referenceImageId = referenceImageId;
        this.rex = rex;
        this.sheddingLevel = sheddingLevel;
        this.shortLegs = shortLegs;
        this.socialNeeds = socialNeeds;
        this.strangerFriendly = strangerFriendly;
        this.suppressedTail = suppressedTail;
        this.temperament = temperament;
        this.vcahospitalsUrl = vcahospitalsUrl;
        this.vetstreetUrl = vetstreetUrl;
        this.vocalisation = vocalisation;
        this.weight = weight;
        this.wikipediaUrl = wikipediaUrl;
    }

    protected Breeds(Parcel in) {
        if (in.readByte() == 0) {
            adaptability = null;
        } else {
            adaptability = in.readInt();
        }
        if (in.readByte() == 0) {
            affectionLevel = null;
        } else {
            affectionLevel = in.readInt();
        }
        altNames = in.readString();
        cfaUrl = in.readString();
        if (in.readByte() == 0) {
            childFriendly = null;
        } else {
            childFriendly = in.readInt();
        }
        countryCode = in.readString();
        countryCodes = in.readString();
        description = in.readString();
        if (in.readByte() == 0) {
            dogFriendly = null;
        } else {
            dogFriendly = in.readInt();
        }
        if (in.readByte() == 0) {
            energyLevel = null;
        } else {
            energyLevel = in.readInt();
        }
        if (in.readByte() == 0) {
            experimental = null;
        } else {
            experimental = in.readInt();
        }
        if (in.readByte() == 0) {
            grooming = null;
        } else {
            grooming = in.readInt();
        }
        if (in.readByte() == 0) {
            hairless = null;
        } else {
            hairless = in.readInt();
        }
        if (in.readByte() == 0) {
            healthIssues = null;
        } else {
            healthIssues = in.readInt();
        }
        if (in.readByte() == 0) {
            hypoallergenic = null;
        } else {
            hypoallergenic = in.readInt();
        }
        id = in.readString();
        image = in.readParcelable(Image.class.getClassLoader());
        if (in.readByte() == 0) {
            indoor = null;
        } else {
            indoor = in.readInt();
        }
        if (in.readByte() == 0) {
            intelligence = null;
        } else {
            intelligence = in.readInt();
        }
        if (in.readByte() == 0) {
            lap = null;
        } else {
            lap = in.readInt();
        }
        lifeSpan = in.readString();
        name = in.readString();
        if (in.readByte() == 0) {
            natural = null;
        } else {
            natural = in.readInt();
        }
        origin = in.readString();
        if (in.readByte() == 0) {
            rare = null;
        } else {
            rare = in.readInt();
        }
        referenceImageId = in.readString();
        if (in.readByte() == 0) {
            rex = null;
        } else {
            rex = in.readInt();
        }
        if (in.readByte() == 0) {
            sheddingLevel = null;
        } else {
            sheddingLevel = in.readInt();
        }
        if (in.readByte() == 0) {
            shortLegs = null;
        } else {
            shortLegs = in.readInt();
        }
        if (in.readByte() == 0) {
            socialNeeds = null;
        } else {
            socialNeeds = in.readInt();
        }
        if (in.readByte() == 0) {
            strangerFriendly = null;
        } else {
            strangerFriendly = in.readInt();
        }
        if (in.readByte() == 0) {
            suppressedTail = null;
        } else {
            suppressedTail = in.readInt();
        }
        temperament = in.readString();
        vcahospitalsUrl = in.readString();
        vetstreetUrl = in.readString();
        if (in.readByte() == 0) {
            vocalisation = null;
        } else {
            vocalisation = in.readInt();
        }
        weight = in.readParcelable(Weight.class.getClassLoader());
        wikipediaUrl = in.readString();
    }

    public static final Creator<Breeds> CREATOR = new Creator<Breeds>() {
        @Override
        public Breeds createFromParcel(Parcel in) {
            return new Breeds(in);
        }

        @Override
        public Breeds[] newArray(int size) {
            return new Breeds[size];
        }
    };

    public Integer getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(Integer adaptability) {
        this.adaptability = adaptability;
    }

    public Integer getAffectionLevel() {
        return affectionLevel;
    }

    public void setAffectionLevel(Integer affectionLevel) {
        this.affectionLevel = affectionLevel;
    }

    public String getAltNames() {
        return altNames;
    }

    public void setAltNames(String altNames) {
        this.altNames = altNames;
    }

    public String getCfaUrl() {
        return cfaUrl;
    }

    public void setCfaUrl(String cfaUrl) {
        this.cfaUrl = cfaUrl;
    }

    public Integer getChildFriendly() {
        return childFriendly;
    }

    public void setChildFriendly(Integer childFriendly) {
        this.childFriendly = childFriendly;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCodes() {
        return countryCodes;
    }

    public void setCountryCodes(String countryCodes) {
        this.countryCodes = countryCodes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDogFriendly() {
        return dogFriendly;
    }

    public void setDogFriendly(Integer dogFriendly) {
        this.dogFriendly = dogFriendly;
    }

    public Integer getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(Integer energyLevel) {
        this.energyLevel = energyLevel;
    }

    public Integer getExperimental() {
        return experimental;
    }

    public void setExperimental(Integer experimental) {
        this.experimental = experimental;
    }

    public Integer getGrooming() {
        return grooming;
    }

    public void setGrooming(Integer grooming) {
        this.grooming = grooming;
    }

    public Integer getHairless() {
        return hairless;
    }

    public void setHairless(Integer hairless) {
        this.hairless = hairless;
    }

    public Integer getHealthIssues() {
        return healthIssues;
    }

    public void setHealthIssues(Integer healthIssues) {
        this.healthIssues = healthIssues;
    }

    public Integer getHypoallergenic() {
        return hypoallergenic;
    }

    public void setHypoallergenic(Integer hypoallergenic) {
        this.hypoallergenic = hypoallergenic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Integer getIndoor() {
        return indoor;
    }

    public void setIndoor(Integer indoor) {
        this.indoor = indoor;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getLap() {
        return lap;
    }

    public void setLap(Integer lap) {
        this.lap = lap;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNatural() {
        return natural;
    }

    public void setNatural(Integer natural) {
        this.natural = natural;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getRare() {
        return rare;
    }

    public void setRare(Integer rare) {
        this.rare = rare;
    }

    public String getReferenceImageId() {
        return referenceImageId;
    }

    public void setReferenceImageId(String referenceImageId) {
        this.referenceImageId = referenceImageId;
    }

    public Integer getRex() {
        return rex;
    }

    public void setRex(Integer rex) {
        this.rex = rex;
    }

    public Integer getSheddingLevel() {
        return sheddingLevel;
    }

    public void setSheddingLevel(Integer sheddingLevel) {
        this.sheddingLevel = sheddingLevel;
    }

    public Integer getShortLegs() {
        return shortLegs;
    }

    public void setShortLegs(Integer shortLegs) {
        this.shortLegs = shortLegs;
    }

    public Integer getSocialNeeds() {
        return socialNeeds;
    }

    public void setSocialNeeds(Integer socialNeeds) {
        this.socialNeeds = socialNeeds;
    }

    public Integer getStrangerFriendly() {
        return strangerFriendly;
    }

    public void setStrangerFriendly(Integer strangerFriendly) {
        this.strangerFriendly = strangerFriendly;
    }

    public Integer getSuppressedTail() {
        return suppressedTail;
    }

    public void setSuppressedTail(Integer suppressedTail) {
        this.suppressedTail = suppressedTail;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getVcahospitalsUrl() {
        return vcahospitalsUrl;
    }

    public void setVcahospitalsUrl(String vcahospitalsUrl) {
        this.vcahospitalsUrl = vcahospitalsUrl;
    }

    public String getVetstreetUrl() {
        return vetstreetUrl;
    }

    public void setVetstreetUrl(String vetstreetUrl) {
        this.vetstreetUrl = vetstreetUrl;
    }

    public Integer getVocalisation() {
        return vocalisation;
    }

    public void setVocalisation(Integer vocalisation) {
        this.vocalisation = vocalisation;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public String getWikipediaUrl() {
        return wikipediaUrl;
    }

    public void setWikipediaUrl(String wikipediaUrl) {
        this.wikipediaUrl = wikipediaUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        if (adaptability == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(adaptability);
        }
        if (affectionLevel == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(affectionLevel);
        }
        dest.writeString(altNames);
        dest.writeString(cfaUrl);
        if (childFriendly == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(childFriendly);
        }
        dest.writeString(countryCode);
        dest.writeString(countryCodes);
        dest.writeString(description);
        if (dogFriendly == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(dogFriendly);
        }
        if (energyLevel == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(energyLevel);
        }
        if (experimental == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(experimental);
        }
        if (grooming == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(grooming);
        }
        if (hairless == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(hairless);
        }
        if (healthIssues == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(healthIssues);
        }
        if (hypoallergenic == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(hypoallergenic);
        }
        dest.writeString(id);
        dest.writeParcelable(image, flags);
        if (indoor == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(indoor);
        }
        if (intelligence == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(intelligence);
        }
        if (lap == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(lap);
        }
        dest.writeString(lifeSpan);
        dest.writeString(name);
        if (natural == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(natural);
        }
        dest.writeString(origin);
        if (rare == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(rare);
        }
        dest.writeString(referenceImageId);
        if (rex == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(rex);
        }
        if (sheddingLevel == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(sheddingLevel);
        }
        if (shortLegs == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(shortLegs);
        }
        if (socialNeeds == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(socialNeeds);
        }
        if (strangerFriendly == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(strangerFriendly);
        }
        if (suppressedTail == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(suppressedTail);
        }
        dest.writeString(temperament);
        dest.writeString(vcahospitalsUrl);
        dest.writeString(vetstreetUrl);
        if (vocalisation == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(vocalisation);
        }
        dest.writeParcelable(weight, flags);
        dest.writeString(wikipediaUrl);
    }

}