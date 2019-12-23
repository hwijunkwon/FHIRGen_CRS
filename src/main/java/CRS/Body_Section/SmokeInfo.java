package CRS.Body_Section;

import CRS.Terminology;
import CRS.BaseResource;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Resource;

//흡연상태
public class SmokeInfo extends BaseResource {
    static int resourceNum = 0;
    Observation observation;
    public String smokeStatus, smokeStatusCode;

    public SmokeInfo(Resource resource){
        observation = (Observation)resource;
    }

    //흡연상태코드 명칭, 흡엽상태코드
    public SmokeInfo(String smokeStatus, String smokeStatusCode){
        observation = new Observation();
        this.setMetaData(observation, Terminology.SMOKE_INFO, resourceNum);
        this.smokeStatus = smokeStatus;
        this.smokeStatusCode = smokeStatusCode;

        observation.getCode().addCoding()
                .setCode(smokeStatusCode)
                .setDisplay(smokeStatus);
        observation.setStatus(Observation.ObservationStatus.FINAL);
    }

}
