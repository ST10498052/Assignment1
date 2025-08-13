public class SeriesModel {
    private String seriesId;
    private String seriesName;
    private int seriesAge;
    private String seriesNumberOfEps;

    public SeriesModel(String seriesId, String seriesName, int seriesAge, String seriesNumberOfEps) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.seriesNumberOfEps = seriesNumberOfEps;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public int getSeriesAge() {
        return seriesAge;
    }

    public void setSeriesAge(int seriesAge) {
        this.seriesAge = seriesAge;
    }

    public String getSeriesNumberOfEps() {
        return seriesNumberOfEps;
    }

    public void setSeriesNumberOfEps(String seriesNumberOfEps) {
        this.seriesNumberOfEps = seriesNumberOfEps;
    }

    @Override
    public String toString() {
        return "Series ID: " + seriesId +
                ", Name: " + seriesName +
                ", Age Restriction: " + seriesAge +
                ", Episodes: " + seriesNumberOfEps;
    }
}
