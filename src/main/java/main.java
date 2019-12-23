
import CRS.Body_Section.*;
import Image_generator.ImageGenerator;
import ca.uhn.fhir.context.FhirContext;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Enumerations;
import CRS.*;
import CRS.Header_Section.*;

public class main {
    public static void main(String[] args){

        //------------------header section----------------------
        //문서정보
        DocumentInfo documentInfo = new DocumentInfo("임상문서명", "임상문서코드", "문서id", "의뢰번호");
        //환자정보
        PatientInfo patientInfo = new PatientInfo("환자id", "성명", "19910101", Enumerations.AdministrativeGender.MALE,
                "010-1111-1111", "주소", "진료구분코드", "진료구분코드명칭");
        //진료의정보
        PractitionerInfo practitionerInfo = new PractitionerInfo("진료의성명", "면허번호", "010-1111-1111", "진료과명", "진료과코드");
        //기관정보
        OrganizationInfo organizationInfo = new OrganizationInfo("기관식별번호", "기관기호", "기관명", "010-1234-1234", "주소");
        //문서작성자정보
        DocumentWriterInfo documentWriterInfo = new DocumentWriterInfo("문서작성자 id", "문서작성자 성명", "문서작성자 연락처");

        //------------------body section----------------------
        //진단내역
        DiagnosisInfo diagnosisInfo = new DiagnosisInfo("20190101", "상병명","상병코드","환자 리소스 id");
        //약물처방내역
        MedicationInfo medicationInfo = new MedicationInfo("20190101", "처방약품명", "처방약품코드",
                "주성분명", "주성분코드", "1", "복용단위", "1", "30", "용법");

        //검체검사결과
        TestResultInfo testResultInfo1 = new TestResultInfo(Terminology.SPECIMEN_TEST_RESULT_INFO, "20190101", "검사항목명", "검사코드", "검사명", "검사결과값", "참고치");
        //병리검사결과 - testList와 testCode는 비워둠
        TestResultInfo testResultInfo2 = new TestResultInfo(Terminology.PATHOLOGY_TEST_RESULT_INFO, "20190101", "", "검사코드", "검사명", "검사결과값", "참고치");
        //영상검사결과 - testList와 testCode는 비워둠
        TestResultInfo testResultInfo3 = new TestResultInfo(Terminology.IMAGE_TEST_RESULT_INFO, "20190101", "", "검사코드", "검사명", "검사결과값", "참고치");
        //기능검사결과 - testList와 testCode는 비워둠
        TestResultInfo testResultInfo4 = new TestResultInfo(Terminology.FUNCTION_TEST_RESULT_INFO, "20190101", "", "검사코드", "검사명", "검사결과값", "참고치");
        //수술내역
        ProcedureInfo procedureInfo = new ProcedureInfo("20190101", "수술명", "수술코드", "수술후진단명", "마취종류", "환자 리소스 id");
        //알러지 및 부작용
        AllergyInfo allergyInfo = new AllergyInfo("20190101","알러지요인명","알러지코드","알러지이름","반응","환자 리소스 id");
        //예방접종내역
        ImmunizationInfo immunizationInfo = new ImmunizationInfo("20190101", "예방접종명","예방접종코드", "백신명", "1");
        //생체신호 및 상태
        VitalsignInfo vitalsignInfo = new VitalsignInfo("20190101", "키", "몸무게", "혈압(확장기)", "혈압(수축기)", "체온");
        //흡연상태
        SmokeInfo smokeInfo = new SmokeInfo("흡연상태", "흡연상태코드");
        //음주상태
        DrinkInfo drinkInfo = new DrinkInfo("음주상태", "음주상태코드");
        //법정 전염성 감염병
        InfectionInfo infectionInfo = new InfectionInfo("20190101", "20190102", "감염병명", "20190103",
                "환자분류", "확진검사결과", "입원여부", "추정감역지역", "환자 리소스 id");


        //Bundle에 리소스 추가
        documentInfo.addResource(patientInfo.getResource());
        documentInfo.addResource(practitionerInfo.getResource());
        documentInfo.addResource(organizationInfo.getResource());
        documentInfo.addResource(documentWriterInfo.getResource());
        documentInfo.addResource(allergyInfo.getResource());
        documentInfo.addResource(diagnosisInfo.getResource());
        documentInfo.addResource(drinkInfo.getResource());
        documentInfo.addResource(immunizationInfo.getResource());
        documentInfo.addResource(medicationInfo.getResource());
        documentInfo.addResource(procedureInfo.getResource());
        documentInfo.addResource(smokeInfo.getResource());
        documentInfo.addResource(testResultInfo1.getResource());
        documentInfo.addResource(testResultInfo2.getResource());
        documentInfo.addResource(testResultInfo3.getResource());
        documentInfo.addResource(testResultInfo4.getResource());
        documentInfo.addResource(vitalsignInfo.getResource());
        documentInfo.addResource(infectionInfo.getResource());

        //Bundle 출력
        FhirContext ctx = FhirContext.forR4();
        System.out.println(ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(documentInfo.getResource()));

        patientInfo.getFileFromResource();
        practitionerInfo.getFileFromResource();
        organizationInfo.getFileFromResource();
        documentWriterInfo.getFileFromResource();
        allergyInfo.getFileFromResource();
        diagnosisInfo.getFileFromResource();
        drinkInfo.getFileFromResource();
        immunizationInfo.getFileFromResource();
        medicationInfo.getFileFromResource();
        procedureInfo.getFileFromResource();
        smokeInfo.getFileFromResource();
        testResultInfo1.getFileFromResource();
        testResultInfo2.getFileFromResource();
        testResultInfo3.getFileFromResource();
        testResultInfo4.getFileFromResource();
        vitalsignInfo.getFileFromResource();
        infectionInfo.getFileFromResource();
        documentInfo.getFileFromResource();

        //CRS 이미지 생성
        ImageGenerator.makeImage1(documentInfo, patientInfo, organizationInfo, practitionerInfo, documentWriterInfo,
                diagnosisInfo, medicationInfo, testResultInfo1, testResultInfo2);

        ImageGenerator.makeImage2(testResultInfo3,testResultInfo4,procedureInfo,allergyInfo,immunizationInfo,vitalsignInfo,
                smokeInfo,drinkInfo,infectionInfo);



    }
}
