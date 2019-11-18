package CRS.Header_Section;

import org.hl7.fhir.r4.model.Practitioner;
import CRS.Terminology;
import CRS.BaseResource;

//진료의 정보
public class PractitionerInfo extends BaseResource {
    static int resourceNum = 0;
    Practitioner practitioner = new Practitioner();

    //의료진성명, 의료진면허번호, 의료진 연락처, 진료과명, 진료과코드
    public PractitionerInfo(String name, String licenceNum, String tel,
                            String department, String departmentCode){

        this.setMetaData(practitioner, Terminology.PRACTITIONER_INFO, resourceNum);

        practitioner.addName().setText(name);
        practitioner.addIdentifier().setValue(licenceNum);
        practitioner.addTelecom().setValue(tel);
        practitioner.addQualification().getCode().addCoding()
                .setDisplay(department)
                .setCode(departmentCode);
    }


}
