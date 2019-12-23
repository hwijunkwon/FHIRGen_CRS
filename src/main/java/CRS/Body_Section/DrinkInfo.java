package CRS.Body_Section;

import CRS.Terminology;
import CRS.BaseResource;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Resource;

//음주상태
public class DrinkInfo extends BaseResource {
    static int resourceNum = 0;
    Observation observation;
    public String drinkStatus,  drinkStatusCode;

    public DrinkInfo(Resource resource){
        observation = (Observation)resource;
    }

                     //음주상태코드 명칭, 음주상태코드
    public DrinkInfo(String drinkStatus, String drinkStatusCode){
        observation = new Observation();
        this.setMetaData(observation, Terminology.DRINK_INFO, resourceNum);
        this.drinkStatus = drinkStatus;
        this.drinkStatusCode = drinkStatusCode;

        observation.getCode().addCoding()
                .setCode(drinkStatusCode)
                .setDisplay(drinkStatus);
        observation.setStatus(Observation.ObservationStatus.FINAL);
    }


}
