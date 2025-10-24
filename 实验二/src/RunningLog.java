import java.lang.reflect.Type;
import java.util.Date;


public class RunningLog {
    private Date dateTime;
    private String event;
    private Type type;
    private String note;

    public enum Type {
        INFO, ERROR, WARN
    }

    public RunningLog(Date dateTime, String event, Type type, String note) {
        this.dateTime = dateTime;
        this.event = event;
        this.type = type;
        this.note = note;
    }


    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dataTime) {
        this.dateTime = dataTime;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Type getType() {
        return type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


}
