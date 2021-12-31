public class Tile {
    boolean dangerZone;
    boolean isQueen;

    Tile(boolean dz, boolean queen)
    {
        dangerZone = dz;
        isQueen = queen;
    }

    public boolean isDangerZone() {
        return dangerZone;
    }

    public void setDangerZone(boolean dangerZone) {
        this.dangerZone = dangerZone;
    }

    public boolean isQueen() {
        return isQueen;
    }

    public void setQueen(boolean queen) {
        isQueen = queen;
    }

    public boolean placeable()
    {
        if (!isQueen)
        {
            if (!isDangerZone())
            {
                return true;
            }
        }
        return false;
    }


}
