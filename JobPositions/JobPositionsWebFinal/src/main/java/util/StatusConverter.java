package util;

import java.util.Arrays;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import enumeration.JobStatus;

@FacesConverter(value="statusConverter")
public class StatusConverter implements Converter{

	private List<JobStatus> status = Arrays.asList(JobStatus.values());

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		JobStatus result = null;
		if (value != null) {
			for (JobStatus status : status)
				if (status.name().equals(value)) {
					result = status;
				}
		}
		return result;
	}


	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			JobStatus status = (JobStatus) value;
			return status.name() == null ? null : status.name();
		}
		return "";
	}
}




