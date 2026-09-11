package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SantanderHomePage;

public class SantanderTest extends BaseTest {


    // =========================
    // PERSONAS
    // =========================

	@DataProvider(name = "personasOptions")
	public Object[][] personasOptions() {
	    return new Object[][] {

	        // Crédito y financiamiento
	        {
	            "Tarjetas de crédito",
	            "https://www.santander.com.mx/personas/credito-y-financiamiento/tarjetas-de-credito/"
	        },
	        {
	            "Crédito personal",
	            "https://www.santander.com.mx/personas/credito-y-financiamiento/creditos-personales/"
	        },
	        {
	            "Crédito hipotecario",
	            "https://www.santander.com.mx/personas/credito-y-financiamiento/creditos-hipotecarios/"
	        },
	        {
	            "Simulador de hipoteca",
	            "https://www.santander.com.mx/personas/credito-y-financiamiento/creditos-hipotecarios/simulador-hipotecario/"
	        },
	        {
	            "Crédito automotríz",
	            "https://www.santander.com.mx/personas/credito-y-financiamiento/credito-automotriz/"
	        },
	        {
	            "Buró de crédito",
	            "https://www.santander.com.mx/personas/credito-y-financiamiento/buro-de-credito/"
	        },

	        // Canales digitales
	        {
	            "Santander digital",
	            "https://www.santander.com.mx/personas/santander-digital/"
	        },
	        {
	            "App Santander",
	            "https://www.santander.com.mx/personas/santander-digital/app-santander/"
	        },
	        {
	            "Santander Web",
	            "https://www.santander.com.mx/personas/santander-digital/santander-web/"
	        },
	        {
	            "Límite por transacción",
	            "https://www.santander.com.mx/personas/santander-digital/limite-por-transaccion/"
	        },

	        // Tipo de cuenta
	        {
	            "Cuentas",
	            "https://www.santander.com.mx/personas/cuentas/"
	        },
	        {
	            "Básica",
	            "https://www.santander.com.mx/personas/cuentas/basica/"
	        },
	        {
	            "Nómina",
	            "https://www.santander.com.mx/personas/cuentas/basica-nomina/"
	        },
	        {
	            "Cheques",
	            "https://www.santander.com.mx/personas/cuentas/cheque-saldo-promedio/"
	        },
	        {
	            "Portabilidad de nómina",
	            "https://www.santander.com.mx/personas/cuentas/portabilidad-de-nomina/"
	        },

	        // Ahorro e inversión
	        {
	            "Fondos de inversión",
	            "https://www.santander.com.mx/personas/inversiones/#fondos-de-inversion"
	        },
	        {
	            "Inversiones a plazo",
	            "https://www.santander.com.mx/personas/inversiones/#inversiones-a-plazo"
	        },
	        {
	            "Notas estructuradas",
	            "https://www.santander.com.mx/personas/inversiones/#notas-estructuradas"
	        },

	        // Seguros
	        {
	            "Auto",
	            "https://www.santander.com.mx/personas/seguros.html#auto"
	        },
	        {
	            "Vida",
	            "https://www.santander.com.mx/personas/seguros.html#vida"
	        },
	        {
	            "Hogar",
	            "https://www.santander.com.mx/personas/seguros.html#hogar"
	        },
	        {
	            "Ahorro",
	            "https://www.santander.com.mx/personas/seguros.html#ahorro"
	        },
	        {
	            "Gastos médicos",
	            "https://www.santander.com.mx/personas/seguros.html#gastos-medicos"
	        },
	        {
	            "Pertenencias",
	            "https://www.santander.com.mx/personas/seguros.html#pertenencias"
	        },

	        // Información y ayuda
	        {
	            "SuperLínea",
	            "https://www.santander.com.mx/personas/superlinea.html"
	        },
	        {
	            "Sucursales",
	            "https://www.santander.com.mx/personas/sucursales.html"
	        },
	        {
	            "Cajeros automáticos",
	            "https://www.santander.com.mx/personas/cajeros-automaticos.html"
	        },
	        {
	            "Canales alternos",
	            "https://www.santander.com.mx/personas/operaciones-canales-alternos/index.html"
	        },
	        {
	            "Centro de ayuda",
	            "https://www.santander.com.mx/personas/centro-de-ayuda.html"
	        },
	        {
	            "Centro de seguridad",
	            "https://www.santander.com.mx/personas/informacion-y-ayuda/centro-de-seguridad/"
	        },
	        {
	            "Tutoriales",
	            "https://www.santander.com.mx/personas/tutoriales.html"
	        },
	        {
	            "Términos y condiciones",
	            "https://www.santander.com.mx/tyc"
	        },
	        {
	            "Regulación",
	            "https://www.santander.com.mx/personas/regulacion/tramite-por-defuncion.html"
	        },

	        // Beneficios
	        {
	            "Select",
	            "https://www.santander.com.mx/personas/select.html"
	        },
	        {
	            "Promociones Santander",
	            "https://www.santander.com.mx/promociones/"
	        },
	        {
	            "Unique Rewards",
	            "https://www.uniquerewards.santander.com.mx/web/home"
	        },
	        {
	            "Soluciones para colectivos",
	            "https://www.santander.com.mx/personas/colectivos.html"
	        },
	        {
	            "Mundo hogar",
	            "https://www.mundohogar.com.mx/"
	            
	        },
	        {
	            "Cashback",
	            "https://www.santander.com.mx/cashback.html"
	        }
	    };
	}

    @Test(dataProvider = "personasOptions")
    public void shouldNavigateToPersonasOption(
            String option,
            String expectedUrl) {

        SantanderHomePage homePage = new SantanderHomePage(driver);

        homePage.openPersonasMenu();
        homePage.clickPersonasOption(option);

        Assert.assertTrue(
            homePage.checkUrl(expectedUrl),
            "The " + option + " page should be loaded"
        );
    }


    // =========================
    // EMPRESAS
    // =========================

    @DataProvider(name = "empresasOptions")
    public Object[][] empresasOptions() {
        return new Object[][] {
            {
                "Empresas y gobierno",
                "https://www.santander.com.mx/bei/home.html"
            },
            {
                "Multinacionales",
                "https://www.santander.com.mx/personas/acerca-del-banco/multinacionales.html"
            }
        };
    }

    @Test(dataProvider = "empresasOptions")
    public void shouldNavigateToEmpresasOption(
            String option,
            String expectedUrl) {

        SantanderHomePage homePage = new SantanderHomePage(driver);

        homePage.openEmpresasMenu();
        homePage.clickEmpresasOption(option);

        Assert.assertTrue(
            homePage.checkUrl(expectedUrl),
            "The " + option + " page should be loaded"
        );
    }


    // =========================
    // PYMES
    // =========================

    @DataProvider(name = "pymesOptions")
    public Object[][] pymesOptions() {
        return new Object[][] {
            {
                "Santander Pyme",
                "https://www.santander.com.mx/pyme.html"
            },
            {
                "Divisas y coberturas",
                "https://www.santander.com.mx/pyme/coberturas-y-cambios.html"
            },
            {
                "Cuentas",
                "https://www.santander.com.mx/pyme/cuentas.html"
            },
            {
                "Negocio internacional",
                "https://www.santander.com.mx/pyme/negocio-internacional.html"
            },
            {
                "Paquetes Pymes",
                "https://www.santander.com.mx/pyme/paquetes-pymes.html"
            },
            {
                "Créditos",
                "https://www.santander.com.mx/pyme/creditos.html"
            },
            {
                "Seguros",
                "https://www.santander.com.mx/pyme/seguros.html"
            },
            {
                "Alianzas",
                "https://www.santander.com.mx/pyme/alianzas.html"
            },
            {
                "Negocio transaccional",
                "https://www.santander.com.mx/pyme/negocio-transaccional.html"
            },
            {
                "Ecosistema no financiero",
                "https://www.santander.com.mx/pyme/ecosistemas-pyme.html"
            },
            {
                "Inversiones",
                "https://www.santander.com.mx/pyme/inversiones.html"
            }
        };
    }

    @Test(dataProvider = "pymesOptions")
    public void shouldNavigateToPymesOption(
            String option,
            String expectedUrl) {

        SantanderHomePage homePage = new SantanderHomePage(driver);

        homePage.openPymesMenu();
        homePage.clickPymesOption(option);

        Assert.assertTrue(
            homePage.checkUrl(expectedUrl),
            "The " + option + " page should be loaded"
        );
    }


    // =========================
    // BANCA PRIVADA
    // =========================

    @Test
    public void shouldNavigateToBancaPrivada() {

        SantanderHomePage homePage = new SantanderHomePage(driver);

        homePage.clickBancaPrivada();

        Assert.assertTrue(
            homePage.checkUrl(
                "https://www.santander.com.mx/bp/home/"
            ),
            "The Banca Privada page should be loaded"
        );
    }


    // =========================
    // ACERCA DEL BANCO
    // =========================

    @DataProvider(name = "acercaBancoOptions")
    public Object[][] acercaBancoOptions() {
        return new Object[][] {
            {
                "Fundación Santander",
                "https://www.santander.com.mx/personas/acerca-del-banco/fundacion-santander.html"
            },
            {
                "Blog",
                "https://www.santander.com.mx/personas/blog.html"
            },
            {
                "Sostenibilidad",
                "https://www.santander.com.mx/personas/acerca-del-banco/responsabilidad-social.html"
            },
            {
                "Educación Financiera",
                "https://www.santander.com.mx/educacion-financiera/"
            },
            {
                "Inversionistas",
                "https://www.santander.com.mx/ir/home/"
            },
            {
                "Sala de comunicación",
                "https://www.santander.com.mx/ceb/sala_prensa_2026.html"
            },
            {
                "Bolsa de trabajo",
                "https://www.santander.com.mx/personas/bolsa-de-trabajo.html"
            }
        };
    }

    @Test(dataProvider = "acercaBancoOptions")
    public void shouldNavigateToAcercaBancoOption(
            String option,
            String expectedUrl) {

        SantanderHomePage homePage = new SantanderHomePage(driver);

        homePage.openAcercaBancoMenu();
        homePage.clickAcercaBancoOption(option);

        Assert.assertTrue(
            homePage.checkUrl(expectedUrl),
            "The " + option + " page should be loaded"
        );
    }
}