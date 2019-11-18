package CRS.Body_Section;

import CRS.Terminology;
import CRS.BaseResource;
import org.hl7.fhir.r4.model.Observation;

//음주상태
public class DrinkInfo extends BaseResource {
    static int resourceNum = 0;
    Observation observation = new Observation();

    //음주상태코드 명칭, 음주상태코드
    public DrinkInfo(String drinkStatus, String drinkStatusCode){
        this.setMetaData(observation, Terminology.DRINK_INFO, resourceNum);
        observation.getCode().addCoding()
                .setCode(drinkStatusCode)
                .setDisplay(drinkStatus);
        observation.setStatus(Observation.ObservationStatus.FINAL);
    }


}
