import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ManagedBean
@ViewScoped
public class SearchPositionsBean implements Serializable {

	private static final long serialVersionUID = -8162379384231501618L;
	private List<Integer> positions;
	private String nome;

	public SearchPositionsBean() {
		positions = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			positions.add(i);
		}

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Integer> getPositions() {
		return positions;
	}

}