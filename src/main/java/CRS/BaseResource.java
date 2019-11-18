package CRS;

import ca.uhn.fhir.context.FhirContext;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.Resource;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseResource {
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmdd");
    Resource resource;
    String filename;
    FhirContext ctx = FhirContext.forR4();

    public void setMetaData(Resource res, String ResourceName, int resourceNum){
        this.resource = res;
        filename = ResourceName;
        res.setId(ResourceName + resourceNum++); //*추후 수정해야할듯
        res.getMeta().setLastUpdated(new Date());
    }

    public Resource getResource(){
        return resource;
    }

    public String getStringResource(){
        return ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(this.getResource());
    }

    public void getFileFromResource(){
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("./FHIR Resource/" +filename));
            writer.write(getStringResource());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
