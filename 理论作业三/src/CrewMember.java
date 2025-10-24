public class CrewMember {
    private String crewId;
    private String name;
    private String rank;
    private String contact;
    private Vessel vessel;

    public CrewMember(String crewId,String name,String rank,String contact){
        this.crewId = crewId;
        this.name = name;
        this.rank = rank;
        this.contact = contact;
    }

    // getter

    public String getCrewId() {
        return crewId;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public String getContact() {
        return contact;
    }

    public Vessel getVessel() {
        return vessel;
    }

    //setter
    public void setCrewId(String crewId) {
        this.crewId = crewId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }

}
