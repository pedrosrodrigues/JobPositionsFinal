package interfaces;

import javax.ejb.Local;

import entities.GuideEntity;

@Local
public interface IGuide {

	public void saveGuide(GuideEntity ent);
}
