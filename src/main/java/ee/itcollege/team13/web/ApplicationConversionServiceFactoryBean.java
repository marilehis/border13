package ee.itcollege.team13.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.RooConversionService;

import ee.itcollege.team13.domain.RoomEntity;
import ee.itcollege.team13.domain.RoomType;

/**
 * A central place to register application converters and formatters. 
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
	      registry.addConverter(new RoomEntityConverter());
	}
	
	 static class RoomEntityConverter implements Converter<RoomEntity, String> {
	        public String convert(RoomEntity roomEntity) {
	            return new StringBuilder().append(roomEntity.getRoomEntityId()).append(" ").append(roomEntity.getName()).append(" ").append(roomEntity.getComment()).toString();
	        }
	 }
}
