package account;

import lombok.NonNull;

public class Account {

    private final String name;
    private String space = " ";

    public Account(@NonNull String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        return checkFieldToLength(name) && checkFieldToSpaceInside(name) && checkFieldToSpaceAtTheBorders(name);
    }

    public boolean checkFieldToLength(String field){
        if(field.length() < 3 || field.length() > 19)
            return false;
        return true;
    }

    public boolean checkFieldToSpaceAtTheBorders(String field){
        if(field.startsWith(" ", 0) || field.startsWith(" ", field.length() - 1))
            return false;
        return true;
    }

    public boolean checkFieldToSpaceInside(String field){
        int spaceCount = 0;

        for(int i = 0; i < field.length(); i ++){
            if(Character.isWhitespace(field.charAt(i))){
                spaceCount++;
            }
        }

        return spaceCount == 1;
    }


}
