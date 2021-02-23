package liuyubobobo.code.lp;

public class Bean {

	private String info;
	private int index;
	
	public Bean(int index,String info) {
		this.index = index;
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "Bean [info=" + info + ", index=" + index + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;

		if (obj instanceof Bean) {
			Bean other = (Bean) obj;
			if (other.index != index)
				return false;
			if (info != null) {
				return info.equals(other.info);
			} else {
				return null == other.info;
			}
		}
		
		return false;
	}

}
