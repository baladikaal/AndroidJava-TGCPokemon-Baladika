package com.baladika.tgcpokemon.response;

import java.util.List;

public class Data {
    private String id;
    private String name;
    private String supertype;
    private List<String> subtypes;
    private String hp;
    private List<String> types;
    private String evolvesFrom;
    private List<Attack> attacks;
    private List<Weakness> weaknesses;
    private List<Resistance> resistances;
    private List<String> retreatCost;
    private int convertedRetreatCost;
    private Set set;
    private String number;
    private String artist;
    private String rarity;
    private String flavorText;
    private List<Integer> nationalPokedexNumbers;
    private Legalities legalities;
    private Images images;
    private TcgPlayer tcgplayer;
    private CardMarket cardmarket;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupertype() {
        return supertype;
    }

    public void setSupertype(String supertype) {
        this.supertype = supertype;
    }

    public List<String> getSubtypes() {
        return subtypes;
    }

    public void setSubtypes(List<String> subtypes) {
        this.subtypes = subtypes;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getEvolvesFrom() {
        return evolvesFrom;
    }

    public void setEvolvesFrom(String evolvesFrom) {
        this.evolvesFrom = evolvesFrom;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
    }

    public List<Weakness> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List<Weakness> weaknesses) {
        this.weaknesses = weaknesses;
    }

    public List<Resistance> getResistances() {
        return resistances;
    }

    public void setResistances(List<Resistance> resistances) {
        this.resistances = resistances;
    }

    public List<String> getRetreatCost() {
        return retreatCost;
    }

    public void setRetreatCost(List<String> retreatCost) {
        this.retreatCost = retreatCost;
    }

    public int getConvertedRetreatCost() {
        return convertedRetreatCost;
    }

    public void setConvertedRetreatCost(int convertedRetreatCost) {
        this.convertedRetreatCost = convertedRetreatCost;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public List<Integer> getNationalPokedexNumbers() {
        return nationalPokedexNumbers;
    }

    public void setNationalPokedexNumbers(List<Integer> nationalPokedexNumbers) {
        this.nationalPokedexNumbers = nationalPokedexNumbers;
    }

    public Legalities getLegalities() {
        return legalities;
    }

    public void setLegalities(Legalities legalities) {
        this.legalities = legalities;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public TcgPlayer getTcgplayer() {
        return tcgplayer;
    }

    public void setTcgplayer(TcgPlayer tcgplayer) {
        this.tcgplayer = tcgplayer;
    }

    public CardMarket getCardmarket() {
        return cardmarket;
    }

    public void setCardmarket(CardMarket cardmarket) {
        this.cardmarket = cardmarket;
    }

    public static class Attack {
        private String name;
        private List<String> cost;
        private int convertedEnergyCost;
        private String damage;
        private String text;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getCost() {
            return cost;
        }

        public void setCost(List<String> cost) {
            this.cost = cost;
        }

        public int getConvertedEnergyCost() {
            return convertedEnergyCost;
        }

        public void setConvertedEnergyCost(int convertedEnergyCost) {
            this.convertedEnergyCost = convertedEnergyCost;
        }

        public String getDamage() {
            return damage;
        }

        public void setDamage(String damage) {
            this.damage = damage;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class Weakness {
        private String type;
        private String value;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class Resistance {
        private String type;
        private String value;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class Set {
        private String id;
        private String name;
        private String series;
        private int printedTotal;
        private int total;
        private Legalities legalities;
        private String ptcgoCode;
        private String releaseDate;
        private String updatedAt;
        private Images images;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSeries() {
            return series;
        }

        public void setSeries(String series) {
            this.series = series;
        }

        public int getPrintedTotal() {
            return printedTotal;
        }

        public void setPrintedTotal(int printedTotal) {
            this.printedTotal = printedTotal;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public Legalities getLegalities() {
            return legalities;
        }

        public void setLegalities(Legalities legalities) {
            this.legalities = legalities;
        }

        public String getPtcgoCode() {
            return ptcgoCode;
        }

        public void setPtcgoCode(String ptcgoCode) {
            this.ptcgoCode = ptcgoCode;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Images getImages() {
            return images;
        }

        public void setImages(Images images) {
            this.images = images;
        }
    }

    public static class Legalities {
        private String unlimited;

        public String getUnlimited() {
            return unlimited;
        }

        public void setUnlimited(String unlimited) {
            this.unlimited = unlimited;
        }
    }

    public static class Images {
        private String symbol;
        private String logo;
        private String small;
        private String large;

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }
    }

    public static class TcgPlayer {
        private String url;
        private String updatedAt;
        private Prices prices;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Prices getPrices() {
            return prices;
        }

        public void setPrices(Prices prices) {
            this.prices = prices;
        }
    }

    public static class CardMarket {
        private String url;
        private String updatedAt;
        private Prices prices;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Prices getPrices() {
            return prices;
        }

        public void setPrices(Prices prices) {
            this.prices = prices;
        }
    }

    public static class Prices {
        private Holofoil holofoil;
        private ReverseHolofoil reverseHolofoil;

        public Holofoil getHolofoil() {
            return holofoil;
        }

        public void setHolofoil(Holofoil holofoil) {
            this.holofoil = holofoil;
        }

        public ReverseHolofoil getReverseHolofoil() {
            return reverseHolofoil;
        }

        public void setReverseHolofoil(ReverseHolofoil reverseHolofoil) {
            this.reverseHolofoil = reverseHolofoil;
        }
    }

    public static class Holofoil {
        private double low;
        private double mid;
        private double high;
        private double market;
        private Double directLow;

        public double getLow() {
            return low;
        }

        public void setLow(double low) {
            this.low = low;
        }

        public double getMid() {
            return mid;
        }

        public void setMid(double mid) {
            this.mid = mid;
        }

        public double getHigh() {
            return high;
        }

        public void setHigh(double high) {
            this.high = high;
        }

        public double getMarket() {
            return market;
        }

        public void setMarket(double market) {
            this.market = market;
        }

        public Double getDirectLow() {
            return directLow;
        }

        public void setDirectLow(Double directLow) {
            this.directLow = directLow;
        }
    }

    public static class ReverseHolofoil {
        private double low;
        private double mid;
        private double high;
        private double market;
        private Double directLow;

        public double getLow() {
            return low;
        }

        public void setLow(double low) {
            this.low = low;
        }

        public double getMid() {
            return mid;
        }

        public void setMid(double mid) {
            this.mid = mid;
        }

        public double getHigh() {
            return high;
        }

        public void setHigh(double high) {
            this.high = high;
        }

        public double getMarket() {
            return market;
        }

        public void setMarket(double market) {
            this.market = market;
        }

        public Double getDirectLow() {
            return directLow;
        }

        public void setDirectLow(Double directLow) {
            this.directLow = directLow;
        }
    }
}