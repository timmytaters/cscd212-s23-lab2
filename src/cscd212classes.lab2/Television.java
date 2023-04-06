package cscd212classes.lab2;

public class Television implements Comparable<Television> {
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String make, final String model, final boolean smart, final int screenSize, final int resolution) {
        if (make == null || make.isEmpty() || model == null || model.isEmpty() || screenSize < 32 || resolution < 720) {
            throw new IllegalArgumentException("Invalid parameter in constructor");
        }
        this.make = make;
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        if(resolution==2160){
            this.fourK=true;
        }
        else{
            this.fourK=false;
        }
    }

    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make) {
        this(make, model, smart, screenSize, resolution);
    }

    public int getScreenSize() {
        return this.screenSize;
    }

    public int getResolution() {
        return this.resolution;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        if (this.smart) {
            if (this.fourK) {
                return this.make + "-" + this.model + ", " + this.screenSize + " inch smart tv with 4K resolution";
            } else {
                return this.make + "-" + this.model + ", " + this.screenSize + " inch smart tv with " + this.resolution + " resolution";
            }
        } else {
            if (this.fourK) {
                return this.make + "-" + this.model + ", " + this.screenSize + " inch tv with 4K resolution";
            } else {
                return this.make + "-" + this.model + ", " + this.screenSize + " inch tv with " + this.resolution + " resolution";
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o==this) {
            return true;
        }
        if (o != null){
            if (o instanceof Television) {
                Television another = (Television) o;
                if (this.make.equals(another.make)){
                    if (this.model.equals(another.model)) {
                        if (this.screenSize == another.screenSize) {
                            if (this.resolution == another.resolution) {
                                if (this.smart == another.smart) {
                                    if (this.fourK == another.fourK) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.make.hashCode() + this.model.hashCode() + this.resolution + Boolean.hashCode(this.smart) + Boolean.hashCode(this.fourK);
    }

    @Override
    public int compareTo(Television another) {
        if(another==null){
            throw new IllegalArgumentException("null parameter in the compareTo method");
        }
        if (this.make.compareTo(another.make) == 0) {
            if (this.model.compareTo(another.model) == 0) {
                return this.screenSize - another.screenSize;
            }
            return this.model.compareTo(another.model);
        }
        return this.make.compareTo(another.make);
    }
}
