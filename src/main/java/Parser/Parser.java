package Parser;

import CRS.Body_Section.*;
import CRS.Header_Section.*;
import CRS.Terminology;
import ca.uhn.fhir.context.FhirContext;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Resource;

import java.util.List;

//Bundle을 파싱하면 아래의 인스턴스에 각각에 해당하는 객체가 생성됨. Bundle에 해당내용이 없으면 인스턴스 생성 안됨
public class Parser {
    //header section
    DocumentInfo documentInfo;
    PatientInfo patientInfo;
    PractitionerInfo practitionerInfo;
    OrganizationInfo organizationInfo;
    DocumentWriterInfo documentWriterInfo;
    //body section
    AllergyInfo allergyInfo;
    DiagnosisInfo diagnosisInfo;
    DrinkInfo drinkInfo;
    ImmunizationInfo immunizationInfo;
    InfectionInfo infectionInfo;
    MedicationInfo medicationInfo;
    ProcedureInfo procedureInfo;
    SmokeInfo smokeInfo;
    TestResultInfo spe_testResultInfo;
    TestResultInfo fun_testResultInfo;
    TestResultInfo img_testResultInfo;
    TestResultInfo pat_testResultInfo;
    VitalsignInfo vitalsignInfo;

    public void parseBundleXML(String bundleXML){
        FhirContext ctx = FhirContext.forR4();
        Bundle bundle = (Bundle) ctx.newXmlParser().parseResource(bundleXML);

        List<Bundle.BundleEntryComponent> list = bundle.getEntry();

        for(Bundle.BundleEntryComponent ent: list){
            Resource resource = ent.getResource();
            setResource(resource);
        }
    }

    public void setResource(Resource resource){
        String id = resource.getId();

        if(id == Terminology.PATIENT_INFO){
            patientInfo = new PatientInfo(resource);
        }else if(id == Terminology.PRACTITIONER_INFO){
            practitionerInfo = new PractitionerInfo(resource);
        }else if(id == Terminology.ORGANIZATION_INFO){
            organizationInfo = new OrganizationInfo(resource);
        }else if(id == Terminology.DOCUMENTWRITER_INFO){
            documentWriterInfo = new DocumentWriterInfo(resource);
        }else if(id == Terminology.ALLERGY_INFO){
            allergyInfo = new AllergyInfo(resource);
        }else if(id == Terminology.DIAGNOSIS_INFO){
            diagnosisInfo = new DiagnosisInfo(resource);
        }else if(id == Terminology.DRINK_INFO){
            drinkInfo = new DrinkInfo(resource);
        }else if(id == Terminology.IMMUNIZATION_INFO){
            immunizationInfo = new ImmunizationInfo(resource);
        }else if(id == Terminology.INFECTION_INFO){
            infectionInfo = new InfectionInfo(resource);
        }else if(id == Terminology.MEDICATION_INFO){
            medicationInfo = new MedicationInfo(resource);
        }else if(id == Terminology.PROCEDURE_INFO){
            procedureInfo = new ProcedureInfo(resource);
        }else if(id == Terminology.SMOKE_INFO){
            smokeInfo = new SmokeInfo(resource);
        }else if(id == Terminology.SPECIMEN_TEST_RESULT_INFO){
            spe_testResultInfo = new TestResultInfo(resource);
        }else if(id == Terminology.FUNCTION_TEST_RESULT_INFO){
            fun_testResultInfo = new TestResultInfo(resource);
        }else if(id == Terminology.IMAGE_TEST_RESULT_INFO){
            img_testResultInfo = new TestResultInfo(resource);
        }else if(id == Terminology.PATHOLOGY_TEST_RESULT_INFO){
            pat_testResultInfo = new TestResultInfo(resource);
        }else if(id == Terminology.VITAL_INFO){
            vitalsignInfo = new VitalsignInfo(resource);
        }else{
            System.out.println("No Resource is matched");
        }
    }

    public DocumentInfo getDocumentInfo() {
        return documentInfo;
    }

    public PatientInfo getPatientInfo() {
        return patientInfo;
    }

    public PractitionerInfo getPractitionerInfo() {
        return practitionerInfo;
    }

    public OrganizationInfo getOrganizationInfo() {
        return organizationInfo;
    }

    public DocumentWriterInfo getDocumentWriterInfo() {
        return documentWriterInfo;
    }

    public AllergyInfo getAllergyInfo() {
        return allergyInfo;
    }

    public DiagnosisInfo getDiagnosisInfo() {
        return diagnosisInfo;
    }

    public DrinkInfo getDrinkInfo() {
        return drinkInfo;
    }

    public ImmunizationInfo getImmunizationInfo() {
        return immunizationInfo;
    }

    public InfectionInfo getInfectionInfo() {
        return infectionInfo;
    }

    public MedicationInfo getMedicationInfo() {
        return medicationInfo;
    }

    public ProcedureInfo getProcedureInfo() {
        return procedureInfo;
    }

    public SmokeInfo getSmokeInfo() {
        return smokeInfo;
    }

    public TestResultInfo getSpe_testResultInfo() {
        return spe_testResultInfo;
    }

    public TestResultInfo getFun_testResultInfo() {
        return fun_testResultInfo;
    }

    public TestResultInfo getImg_testResultInfo() {
        return img_testResultInfo;
    }

    public TestResultInfo getPat_testResultInfo() {
        return pat_testResultInfo;
    }

    public VitalsignInfo getVitalsignInfo() {
        return vitalsignInfo;
    }
}
