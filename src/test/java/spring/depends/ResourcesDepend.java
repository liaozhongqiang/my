package spring.depends;

import java.io.IOException;

public class ResourcesDepend {
	
	private ResourcesBean resourcesBean;

	public ResourcesBean getResourcesBean() {
		return resourcesBean;
	}

	public void setResourcesBean(ResourcesBean resourcesBean) {
		this.resourcesBean = resourcesBean;
	}
	
	
	public void init() throws IOException{
		System.out.println("ResourcesDepend:------初始化");
		resourcesBean.getOs().write("ResourcesDepend:------写入资源".getBytes());
	}
	
	public void destroy(){
		System.out.println("ResourcesDepend:------销毁");
	}
	

}
