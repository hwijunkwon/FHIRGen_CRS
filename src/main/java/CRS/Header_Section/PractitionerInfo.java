package CRS.Header_Section;

import org.hl7.fhir.r4.model.Practitioner;
import CRS.Terminology;
import CRS.BaseResource;
import org.hl7.fhir.r4.model.Resource;

//진료의 정보
public class PractitionerInfo extends BaseResource {
    static int resourceNum = 0;
    Practitioner practitioner;
    public String name,licenceNum,  tel,  department,  departmentCode;

    public PractitionerInfo(Resource resource){
        practitioner = (Practitioner) resource;
    }

    //의료진성명, 의료진면허번호, 의료진 연락처, 진료과명, 진료과코드
    public PractitionerInfo(String name, String licenceNum, String tel,
                            String department, String departmentCode){

        practitioner = new Practitioner();
        this.setMetaData(practitioner, Terminology.PRACTITIONER_INFO, resourceNum);
        this. name = name;
        this.licenceNum = licenceNum;
        this.tel = tel;
        this.department = department;
        this.departmentCode =departmentCode;

        practitioner.addName().setText(name);
        practitioner.addIdentifier().setValue(licenceNum);
        practitioner.addTelecom().setValue(tel);
        practitioner.addQualification().getCode().addCoding()
                .setDisplay(department)
                .setCode(departmentCode);
    }


}
