/*
 *
 */

package me.melvins.labs.utils;

import me.melvins.labs.vo.RequestHeaderVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MessageFormatMessageFactory;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author Mels
 */
public class BeanUtils {

    private static final Logger LOGGER = LogManager.getLogger(BeanUtils.class,
            new MessageFormatMessageFactory());

    public static Object fillBean(Map<String, Object> headers, Class clazz) throws InstantiationException,
            IllegalAccessException {

        Object obj = clazz.newInstance();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            for (Map.Entry<String, Object> entry : headers.entrySet()) {
                if (field.getName().equals(entry.getKey())) {
                    field.set(obj, entry.getValue());
                }
            }
        }

        return obj;
    }

}
