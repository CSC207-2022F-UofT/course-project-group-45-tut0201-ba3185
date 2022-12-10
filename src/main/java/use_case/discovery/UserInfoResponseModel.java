package use_case.discovery;

public class UserInfoResponseModel {
    private int age;
    private String name;
    private String hobby;
    private String relationshipType;

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setHobby(String hobby){
        this.hobby = hobby;
    }
    public String getHobby(){
        return hobby;
    }
    public void setRelationshipType(String relationshipType){
        this.relationshipType = relationshipType;
    }

    public String getRelationshipType(){
        return relationshipType;
    }


}
