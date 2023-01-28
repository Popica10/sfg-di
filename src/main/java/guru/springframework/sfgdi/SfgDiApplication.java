package guru.springframework.sfgdi;

import guru.springframework.sfgdi.config.BindingConfig;
import guru.springframework.sfgdi.config.BindingConstructorConfig;
import guru.springframework.sfgdi.controllers.*;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"guru.springframework.sfgdi", "popica.framework"})
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println("------- Primary Bean");
		System.out.println(myController.sayHello());

		System.out.println("------ Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("--------- Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("-------- Constructor" );
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("--------------- Using property source FakeDataSource");
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println("Username for fake datasource: " + fakeDataSource.getUsername());
		System.out.println("Password for fake datasource: " + fakeDataSource.getPassword());

		System.out.println("--------------- Using binding properties ");
		BindingConfig bindingConfig = ctx.getBean(BindingConfig.class);
		System.out.println("Username for fake datasource: " + bindingConfig.getUsername());
		System.out.println("Password for fake datasource: " + bindingConfig.getPassword());

		System.out.println("--------------- Using constructor binding properties ");
		BindingConstructorConfig bindingConstructorConfig = ctx.getBean(BindingConstructorConfig.class);
		System.out.println("Username for fake datasource: " + bindingConstructorConfig.getUsername());
		System.out.println("Password for fake datasource: " + bindingConstructorConfig.getPassword());
	}

}
