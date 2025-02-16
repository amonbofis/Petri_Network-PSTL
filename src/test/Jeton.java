package test;
public class Jeton {
    private int numid;
    private Place position;

    public Jeton(int num, Place position){
        this.numid = num;
        this.position = position;
    }

    public int getNumid(){
        return this.numid;
    }

    public Place getPosition(){
        return this.position;
    }
}
