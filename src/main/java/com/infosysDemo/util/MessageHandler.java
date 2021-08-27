package com.infosysDemo.util;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author angad
 * Date : 14 June 2021
 * This class used for to fetch custom error messages from properties file.
 */
@Component
@PropertySource(value={"classpath:/application.properties"})
public class MessageHandler {

}
