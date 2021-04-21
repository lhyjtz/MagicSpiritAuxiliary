package sample.Tool.Eneity;

/**
 * @autHor LHYJTZ
 * @data 2021年04月21日 16:37
 * 用于保存XML查询数据
 */
public class WildMonsterXMLReadEntity {
    private int id;
    private String WildMonsterName;
    private String WildMonsterGradeRange;
    private String WildMonsterMapID;
    private String WildMonsterMapName;
    private String HideWildMonster;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWildMonsterName() {
        return WildMonsterName;
    }

    public void setWildMonsterName(String wildMonsterName) {
        WildMonsterName = wildMonsterName;
    }

    public String getWildMonsterGradeRange() {
        return WildMonsterGradeRange;
    }

    public void setWildMonsterGradeRange(String wildMonsterGradeRange) {
        WildMonsterGradeRange = wildMonsterGradeRange;
    }

    public String getWildMonsterMapID() {
        return WildMonsterMapID;
    }

    public void setWildMonsterMapID(String wildMonsterMapID) {
        WildMonsterMapID = wildMonsterMapID;
    }

    public String getWildMonsterMapName() {
        return WildMonsterMapName;
    }

    public void setWildMonsterMapName(String wildMonsterMapName) {
        WildMonsterMapName = wildMonsterMapName;
    }

    public String getHideWildMonster() {
        return HideWildMonster;
    }

    public void setHideWildMonster(String hideWildMonster) {
        HideWildMonster = hideWildMonster;
    }


}
