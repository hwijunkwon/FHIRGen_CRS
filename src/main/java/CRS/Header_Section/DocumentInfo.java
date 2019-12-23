package CRS.Header_Section;
import org.hl7.fhir.r4.model.*;
import CRS.Terminology;
import CRS.BaseResource;

//문서정보
public class DocumentInfo extends BaseResource {
    static int resourceNum = 0;
    Bundle bundle;
    int entryNum = 0;
    public String name, code, id, requestNumber;

    public DocumentInfo(Resource resource){
        bundle = (Bundle) resource;
    }

    //임상문서명, 임상문서코드, 문서ID, 의뢰번호
    public DocumentInfo(String name, String code, String id, String requestNumber){
        //기본 메타 정보
        entryNum = 0;
        bundle = new Bundle();
        this.setMetaData(bundle, Terminology.DOCUMENT_INFO, resourceNum);
        this.name = name;
        this.code = code;
        this.id = id;
        this.requestNumber = requestNumber;

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
