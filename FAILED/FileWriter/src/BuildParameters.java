public class BuildParameters {
    String fileName;
    int iterations;
    String charToFill;

    public BuildParameters(String name, int count, String letter){
        this.fileName = name;
        this.iterations = count;
        this.charToFill = letter;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public String getCharToFill() {
        return charToFill;
    }

    public void setCharToFill(String charToFill) {
        this.charToFill = charToFill;
    }
}
