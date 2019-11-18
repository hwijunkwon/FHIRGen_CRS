package CRS.Header_Section;
import org.hl7.fhir.r4.model.*;
import CRS.Terminology;
import CRS.BaseResource;

//문서정보
public class DocumentInfo extends BaseResource {
    static int resourceNum = 0;
    Bundle bundle = new Bundle();
    int entryNum = 0;

    //임상문서명, 임상문서코드, 문서ID, 의뢰번호
    public DocumentInfo(String name, String code, String id, String requestNumber){
        //기본 메타 정보
       this.setMetaData(bundle, Terminology.DOCUMENT_INFO, resourceNum);

        //문서정보
        bundle.getIdentifier().getType().addCoding()
                .setDisplay(name)
                .setCode(code);

        bundle.getIdentifier()
                .setValue(requestNumber)
                .setValue(id);
    }

    public void addResource(Resource resource){
        Bundle.BundleEntryComponent ent = bundle.addEntry();
        ent.setId(entryNum++ + "");
        ent.setResource(resource);
    }
}
