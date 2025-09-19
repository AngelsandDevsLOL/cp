package School;

/**
 This class represents a blank magical scroll, and contains methods
 and variables that are inherited by subclasses representing
 scrolls containing specific magical spells

 ICS4UO Ms Krasteva
 @author Angelina Jiang
 */

public class BlankMagicalScroll {
    private String companyName;
    private int price;
    private int productionYear;
    private String owner;
    private int usagesLeft;
    private boolean locked;
    private String spell;
    private boolean authentication;
    private int condition;

    /**
     * The default constructor of the Blank Magical Scroll
     */

    public BlankMagicalScroll() {
        companyName = "Generic Scroll Brand";
        owner = "someone";
        price = 100;
        productionYear = 2023;
        usagesLeft = 2;
        locked = true;
        spell = "spell";
        authentication = true;
        condition = 100;
    }

    /**
     * A constructor of the BLank Magical Scroll
     *
     * @param company The company name
     * @param price The price of the scroll in dollars
     * @param year The year the scroll was made in
     * @param own The owner's name
     * @param usages The number of usages left
     * @param password The spell's password in order for the spell to work
     * @param authen If the spell is a true spell or a fake
    */
    public BlankMagicalScroll(String company, int price, int year, String own, int usages, boolean lock, String password, boolean authen) {
        companyName = company;
        this.price = price;
        productionYear = year;
        owner = own;
        usagesLeft = usages;
        locked = lock;
        spell = password;
        authentication = authen;
        condition = 100;
    }

    /**
     * @return company name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName The new company name
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the price of the scroll
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price The new price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return The year of production
     */
    public int getProductionYear() {
        return productionYear;
    }

    /**
     * @param productionYear The new production year
     */
    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    /**
     * @return The owner's name
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param newOwner The new owner's name
     */
    public void setOwner(String newOwner) {
        owner = newOwner;
    }

    /**
     * @return The number of usages left
     */
    public int getUsagesLeft() {
        return usagesLeft;
    }

    /**
     * @return A boolean of whether it can be currently used
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * @param locked To change the locked variable
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    /**
     * @return The spell
     */
    public String getSpell() {
        return spell;
    }

    /**
     * @param spell The new spell
     */
    public void setSpell(String spell) {
        this.spell = spell;
    }

    /**
     * @return Whether or not the scroll is certified to be real
     */
    public boolean isAuthentication() {
        return authentication;
    }

    /**
     * @param authentication To change the authentification of the scroll
     */
    public void setAuthentication(boolean authentication) {
        authentication = authentication;
    }

    /**
     * @return the condition of the scroll
     */
    public int getCondition() {
        return condition;
    }

    /**
     * damageScroll method
     *
     * @param amount The amount the condition of the scroll is lowered by
     * This makes sure that the condition of the scroll cannot go to negative
     */
    public void damageScroll(int amount) {
        condition = Math.max(0, condition - amount);
    }

    /**
     * fixScroll condition method
     *
     * Sets the condition to 100 automatically
     */
    public void fixScroll() {
        condition = 100;
    }

    /**
     * fixScroll usages method
     * Will increase the number of usages
     *
     * @param x The number of usages the usagesLeft can be increased by
     */
    public void fixScroll(int x) {
        usagesLeft += x;
    }

    /**
     * castSpell method
     * The castSpell method first makes sure that the spell can be used by checking to make sure it is not locked, the password is right, it is a real scroll, it is usable, and the owner is either the person using the scroll or not
     *
     * @param password The password that is said while using the spell
     * @param caster The person who is casting the spell
     */
    public void castSpell(String password, String caster) {
        if (!locked && password.equals(spell) && authentication && usagesLeft > 0 && condition > 0 && (caster.equals(owner) || owner.equals("none"))) {
            usagesLeft--;
            System.out.println("Spell has been cast by " + caster);
        } else {
            System.out.println("Spell has failed.");
        }
    }
}