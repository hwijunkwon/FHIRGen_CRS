package CRS;

public final class Terminology {

    public static final String LOINC = "http://loinc.org";
    public static final String LOINC_HEIGHT = "8302-2";
    public static final String LOINC_WEIGHT = "3141-9";
    public static final String LOINC_BP_DIA = "8462-4";
    public static final String LOINC_BP_SYS = "8480-6";
    public static final String LOINC_TEMPERATURE = "8310-5";

    //ID생성시 명칭 (ID 생성예, patient11 - 11번째 생성된 Patient Resource)
    //Header section
    public static final String DOCUMENT_INFO = "bundle";//문서정보
    public static final String PATIENT_INFO = "patient";//환자정보
    public static final String ORGANIZATION_INFO = "organization";//의료기관정보
    public static final String PRACTITIONER_INFO = "practitioner";//진료의정보
    public static final String DOCUMENTWRITER_INFO = "person_documentwriter";//문서생성자정보

    //Body Section
    public static final String DIAGNOSIS_INFO = "condition_diagnosis";//진단내역정보
    public static final String MEDICATION_INFO = "medicationstatement";//약물처방내역정보
    public static final String SPECIMEN_TEST_RESULT_INFO = "observation_specimen";//검체검사결과정보
    public static final String PATHOLOGY_TEST_RESULT_INFO = "observation_pathology";//병리검사결과정보
    public static final String IMAGE_TEST_RESULT_INFO = "observation_image";//영상검사결과정보
    public static final String FUNCTION_TEST_RESULT_INFO = "observation_function";//기능검사결과정보
    public static final String PROCEDURE_INFO = "procedure";//수술내역정보
    public static final String ALLERGY_INFO = "allergyintolerance";//알러지및부작용정보
    public static final String IMMUNIZATION_INFO = "immunization";//예방접종내역정보
    public static final String VITAL_INFO = "observation_vital";//생체신호및상태정보
    public static final String SMOKE_INFO = "observation_smoke";//흡연상태정보
    public static final String DRINK_INFO = "observation_drink";//음주상태정보
    public static final String INFECTION_INFO = "condition_infection";//법정전염성감염병정보

}
