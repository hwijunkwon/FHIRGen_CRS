package CRS.Body_Section;

import CRS.Terminology;
import CRS.BaseResource;
import org.hl7.fhir.r4.model.AllergyIntolerance;

import java.text.ParseException;

//알러지 및 부작용 정보
public class AllergyInfo extends BaseResource {
    static int resourceNum = 0;
    AllergyIntolerance allergyIntolerance = new AllergyIntolerance();

    //등록일자, 알러지요인, 알러지요인코드, 알러지명, 반응, 환자 resource id
    public AllergyInfo(String date, String allergyFactor, String allergyFactorCode,
                       String allergyName, String reaction, String patientId){
        this.setMetaData(allergyIntolerance, Terminology.ALLERGY_INFO, resourceNum);
        try {
            allergyIntolerance.setRecordedDate(this.simpleDateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        allergyIntolerance.getCode().setText(allergyName)
                .addCoding()
                .setDisplay(allergyFactor)
                .setCode(allergyFactorCode);

        allergyIntolerance.addReaction().addManifestation().setText(reaction);
        allergyIntolerance.getPatient().setId(patientId);

    }

}
