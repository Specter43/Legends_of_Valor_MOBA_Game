/**
 * A Class representing a cell in Legends of Valor game.
 */
public abstract class CellLV extends Cell {
    private boolean isHero;
    private boolean isMonster;
    private boolean isHeroNexus;
    private boolean isMonsterNexus;
    private boolean isCave;
    private boolean isBush;
    private boolean isKoulou;
    private boolean isObstacle;

    public CellLV(Object content) {
        super(content);
    }

    public boolean isHeroNexus() {
        return isHeroNexus;
    }
    public void setHeroNexus(boolean heroNexus) {
        isHeroNexus = heroNexus;
    }
    public boolean isMonsterNexus() {
        return isMonsterNexus;
    }
    public void setMonsterNexus(boolean monsterNexus) {
        isMonsterNexus = monsterNexus;
    }
    public boolean isCave() {
        return isCave;
    }
    public void setCave(boolean cave) {
        isCave = cave;
    }
    public boolean isBush() {
        return isBush;
    }
    public void setBush(boolean bush) {
        isBush = bush;
    }
    public boolean isKoulou() {
        return isKoulou;
    }
    public void setKoulou(boolean koulou) {
        isKoulou = koulou;
    }
    public boolean isHero() {
        return isHero;
    }
    public void setHero(boolean hero) {
        isHero = hero;
    }
    public boolean isMonster() {
        return isMonster;
    }
    public void setMonster(boolean monster) {
        isMonster = monster;
    }
    public boolean isObstacle() {
        return isObstacle;
    }
    public void setObstacle(boolean obstacle) {
        isObstacle = obstacle;
    }
}
