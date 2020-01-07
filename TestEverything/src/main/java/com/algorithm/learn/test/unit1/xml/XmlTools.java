package com.algorithm.learn.test.unit1.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlTools {
    /**
     * javabean转xml
     *
     * @param entity
     * @return
     */
    public static String serialize(Object entity) {
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(entity.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            StringWriter writer = new StringWriter();
            marshaller.marshal(entity, writer);
            return writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static <T> T deserialize(Class<T> clazz, String content) {
        JAXBContext jc;
        try {
            jc = JAXBContext.newInstance(clazz);
            Unmarshaller u = jc.createUnmarshaller();
            return (T) u.unmarshal(new StringReader(content));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

}
