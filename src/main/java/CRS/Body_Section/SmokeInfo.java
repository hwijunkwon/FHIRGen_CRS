package CRS.Body_Section;

import CRS.Terminology;
import CRS.BaseResource;
import org.hl7.fhir.r4.model.Observation;

//흡연상태
public class SmokeInfo extends BaseResource {
    static int resourceNum = 0;
    Observation observation = new Observation();

    //흡연상태코드 명칭, 흡엽상태코드
    public SmokeInfo(String smokeStatus, String smokeStatusCode){
        this.setMetaData(observation, Terminology.SMOKE_INFO, resourceNum);
        observation.getCode().addCoding()
                .setCode(smokeStatusCode)
                .setDisplay(smokeStatus);
        observation.setStatus(Observation.ObservationStatus.FINAL);
    }

}
