import javax.xml.crypto.Data;
import java.util.Date;

public interface EnergyReporting {


    double getPower();

    double getReport(Date startTime, Date endTime);

}
