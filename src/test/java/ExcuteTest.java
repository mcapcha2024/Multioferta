import WebSite.Locators;
import SetUp.SetUp;
import WebSite.WebSite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExcuteTest {

    private static WebDriver driver;
    private static WebSite webSite;

    public static void main(String[] args) throws InterruptedException {
        driver = SetUp.getDriver();
        webSite = new WebSite(driver);

        // Variables Standar
        String url = "https://tiendaonline.movistar.com.pe/ofertas/movil/multioferta";
        String celular = "999999999";
        String dni = "99999999";
        String horario = "2024-07-20 10:00:00"; //Se debe actualizar la fecha

        // Popup 20% DTO
        webSite.navigateToWebsite(url);
        webSite.validate20DTO("https://centrodetransparencia.movistar.com.pe/politica-local-privacidad", "POPUP 20% DTO"); // Replace with the link URL
        webSite.selectLegal20DTO();
        webSite.inputFormulatio20DTO(celular, dni);
        WebSite.selectHorario20DTO(horario);
        webSite.submitPedido20DTO();
        String mensaje20DTO = webSite.validatePedido20STO();
        if (mensaje20DTO.equals("¡Gracias por contactarnos!")) {
            System.out.println("Prueba exitosa: Se verificó el mensaje de confirmación M20%");
        } else {
            System.out.println("Prueba fallida: El mensaje de confirmación no es el esperado");
        }
        webSite.closeModal20DTO();

        // Popup DELIVERY
        webSite.validateTerminosDelivery("https://www.movistar.com.pe/movil/postpago/portabilidad?utm_source=%28direct%29&amp;utm_medium=%28none%29&amp;utm_campaign=%28direct%29&amp;utm_content=undefined&amp;utm_term=undefined&amp;gclid=&amp;_gl=1*14w1h6w*_gcl_au*MTYxOTMzODg0OS4xNzIxMjM3NzA5*_ga*NDkzMTU1NjI0LjE3MjEyMzc3MDk.*_ga_8Q7MD06RY0*MTcyMTMzMTE0MS43LjEuMTcyMTMzMTE2Ni4zNS4wLjA.#portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_jb7ddqEUWB7j", "POPUP DELIVERY"); // Replace with the link URL
        webSite.openFormularioDelivery();
        webSite.validatePoliticas("https://centrodetransparencia.movistar.com.pe/politica-local-privacidad", "POPUP DELIVERY"); // Replace with the link URL
        webSite.selectPromNove();
        webSite.selectRestricciones();
        webSite.inputFormulario(celular, dni);
        WebSite.selectHorario(horario);
        webSite.submitPedido();
        String mensajeDelivery = webSite.validarPedido();
        if (mensajeDelivery.equals("¡Gracias por contactarnos!")) {
            System.out.println("Prueba exitosa: Se verificó el mensaje de confirmación MDELIVERY");
        } else {
            System.out.println("Prueba fallida: El mensaje de confirmación no es el esperado");
        }
        webSite.closeModal();
        webSite.closeModalDelivery();

        // Banner
        //webSite.cerrarModales(); //Quitar en grupo
        webSite.selecB1Bullet(1);
        webSite.validatePoliticasBanner("https://centrodetransparencia.movistar.com.pe/politica-local-privacidad", "BANNER"); // Replace with the link URL
        webSite.selectPromNoveBanner();
        webSite.inputFormularioBanner(celular, dni);
        WebSite.selectHorarioBanner(horario);
        webSite.submitPedidoBanner();
        String mensajeBanner = webSite.validarPedido();
        if (mensajeBanner.equals("¡Gracias por contactarnos!")) {
            System.out.println("Prueba exitosa: Se verificó el mensaje de confirmación BANNER");
        } else {
            System.out.println("Prueba fallida: El mensaje de confirmación no es el esperado");
        }
        webSite.closeModal();

        // Navegación
        //webSite.cerrarModales();
        //webSite.scrollByPixels(Locators.scrollAmount); //Desplazar la ventana en 500 píxeles

        // Pestaña Equipos + plan (Contodo)
        //webSite.cerrarModales(); //Quitar en grupo
        webSite.scrollByPixels(Locators.scrollAmount); //Scroll 530 píxeles
        webSite.openFormularioContodo();
        webSite.validatePoliticas("https://centrodetransparencia.movistar.com.pe/politica-local-privacidad", "POPUP EQUIPO + PLAN CONTODO"); // Replace with the link URL
        webSite.selectPromNove();
        webSite.selectRestricciones();
        webSite.inputFormulario(celular, dni);
        WebSite.selectHorario(horario);
        webSite.submitPedido();
        String mensajeContodo = webSite.validarPedido();
        if (mensajeContodo.equals("¡Gracias por contactarnos!")) {
            System.out.println("Prueba exitosa: Se verificó el mensaje de confirmación EQUIPOS + PLAN CONTODO");
        } else {
            System.out.println("Prueba fallida: El mensaje de confirmación no es el esperado");
        }
        webSite.closeModal();

        // Pestaña Equipos + plan (Equipos)
        webSite.selectMarca();
        webSite.openFormularioEquipos();
        webSite.validatePoliticas("https://centrodetransparencia.movistar.com.pe/politica-local-privacidad", "POPUP EQUIPO + PLAN EQUIPOS"); // Replace with the link URL
        webSite.selectPromNove();
        webSite.selectRestricciones();
        webSite.inputFormulario(celular, dni);
        WebSite.selectHorario(horario);
        webSite.submitPedido();
        String mensajeEquipos = webSite.validarPedido();
        if (mensajeEquipos.equals("¡Gracias por contactarnos!")) {
            System.out.println("Prueba exitosa: Se verificó el mensaje de confirmación EQUIPOS + PLAN EQUIPOS");
        } else {
            System.out.println("Prueba fallida: El mensaje de confirmación no es el esperado");
        }
        webSite.closeModal();

        // Pestaña Equipos sin plan
        webSite.selectEquiposSinplan();
        webSite.scrollByPixels(Locators.scroll1Amount); //Scroll 220 píxeles
        webSite.validateLoquiero("https://tienda.movistar.com.pe/celulares/liberados?ref_origin=LC_MULTIOFERTA_CARRUSEL_EQUIPOSSINPLAN_LIBERADOS&amp;utm_source=%28direct%29&amp;utm_medium=%28none%29&amp;utm_campaign=%28direct%29&amp;utm_content=undefined&amp;utm_term=undefined&amp;gclid=&amp;_gl=1*1vaozrn*_gcl_au*MTYxOTMzODg0OS4xNzIxMjM3NzA5*_ga*NDkzMTU1NjI0LjE3MjEyMzc3MDk.*_ga_8Q7MD06RY0*MTcyMTI0NTU5Ni4zLjEuMTcyMTI1NzExMC42MC4wLjA.", "EQUIPOS SIN PLAN"); // Replace with the link URL

        // Pestaña Solo Plan
        webSite.scroll2ByPixels(Locators.scroll1Amount); //Scroll 220 píxeles
        webSite.selectSoloplan();
        webSite.scrollByPixels(Locators.scroll1Amount); //Scroll 220 píxeles
        webSite.selectdetalleSoloplan();
        webSite.clickEquipolinea();
        webSite.validatePoliticas("https://centrodetransparencia.movistar.com.pe/politica-local-privacidad", "POPUP EQUIPO + LÍNEA"); // Replace with the link URL
        webSite.selectPromNove();
        webSite.selectRestricciones();
        webSite.inputFormulario(celular, dni);
        WebSite.selectHorario(horario);
        webSite.submitPedido();
        String mensajeEquipoLinea = webSite.validarPedido();
        if (mensajeEquipoLinea.equals("¡Gracias por contactarnos!")) {
            System.out.println("Prueba exitosa: Se verificó el mensaje de confirmación SOLO PLAN - EQUIPOS + LÍNEA");
        } else {
            System.out.println("Prueba fallida: El mensaje de confirmación no es el esperado");
        }
        webSite.closeModal();
        webSite.clickLinea();
        webSite.validatePoliticas("https://centrodetransparencia.movistar.com.pe/politica-local-privacidad", "POPUP SOLO LÍNEA"); // Replace with the link URL
        webSite.selectPromNove();
        webSite.selectRestricciones();
        webSite.inputFormulario(celular, dni);
        WebSite.selectHorario(horario);
        webSite.submitPedido();
        String mensajeLinea = webSite.validarPedido();
        if (mensajeLinea.equals("¡Gracias por contactarnos!")) {
            System.out.println("Prueba exitosa: Se verificó el mensaje de confirmación SOLO PLAN - SOLO LÍNEA");
        } else {
            System.out.println("Prueba fallida: El mensaje de confirmación no es el esperado");
        }
        webSite.closeModal();

        // Promoción
        webSite.scrollByPixels(Locators.scrollAmount); //Scroll 530 píxeles
        webSite.clickPromociones();
        webSite.validatePoliticas("https://centrodetransparencia.movistar.com.pe/politica-local-privacidad", "POPUP PROMOCIONES"); // Replace with the link URL
        webSite.selectPromNove();
        webSite.selectRestricciones();
        webSite.inputFormulario(celular, dni);
        WebSite.selectHorario(horario);
        webSite.submitPedido();
        String mensajePromocion = webSite.validarPedido();
        if (mensajePromocion.equals("¡Gracias por contactarnos!")) {
            System.out.println("Prueba exitosa: Se verificó el mensaje de confirmación PROMOCIONES");
        } else {
            System.out.println("Prueba fallida: El mensaje de confirmación no es el esperado");
        }
        webSite.closeModal();

        // Recomendado
        webSite.clickRecomendado();
        webSite.validatePoliticas("https://centrodetransparencia.movistar.com.pe/politica-local-privacidad", "POPUP RECOMENDADO"); // Replace with the link URL
        webSite.selectPromNove();
        webSite.selectRestricciones();
        webSite.inputFormulario(celular, dni);
        WebSite.selectHorario(horario);
        webSite.submitPedido();
        String mensajeRecomendado = webSite.validarPedido();
        if (mensajeRecomendado.equals("¡Gracias por contactarnos!")) {
            System.out.println("Prueba exitosa: Se verificó el mensaje de confirmación RECOMENDADO");
        } else {
            System.out.println("Prueba fallida: El mensaje de confirmación no es el esperado");
        }
        webSite.closeModal();

        // Cambiate
        webSite.scrollByPixels(Locators.scroll1Amount); //Scroll 220 píxeles
        webSite.validateVerofertas("https://tienda.movistar.com.pe/celulares/portabilidad?ref_origin=LC_MULTIOFERTA_CARD1_PORTA&utm_source=%28direct%29&utm_medium=%28none%29&utm_campaign=%28direct%29&utm_content=undefined&utm_term=undefined&gclid=&_gl=1*tue4tk*_gcl_au*MTYxOTMzODg0OS4xNzIxMjM3NzA5*_ga*NDkzMTU1NjI0LjE3MjEyMzc3MDk.*_ga_8Q7MD06RY0*MTcyMTMzMTE0MS43LjEuMTcyMTMzMTU1Ny4zMC4wLjA.", "CAMBIATE A MOVISTAR");

        // Beneficios
        webSite.scrollByPixels(Locators.scrollAmount); //Scroll 530 píxeles
        webSite.validateMovistartv("https://tv.movistar.com.pe/", "MOVISTAR TV");
        webSite.validateSmartwifi("https://www.movistar.com.pe/hogar/internet/repetidor-wifi?utm_source=%28direct%29&utm_medium=%28none%29&utm_campaign=%28direct%29&utm_content=undefined&utm_term=undefined&gclid=&_gl=1*19cijq4*_gcl_au*MTYxOTMzODg0OS4xNzIxMjM3NzA5*_ga*NDkzMTU1NjI0LjE3MjEyMzc3MDk.*_ga_8Q7MD06RY0*MTcyMTMzMTE0MS43LjEuMTcyMTMzMTQ3OS40MS4wLjA.", "SMART WIFI");
        webSite.validateExclusivos("https://www.movistar.com.pe/hogar/movistar-tv-cable?utm_source=%28direct%29&utm_medium=%28none%29&utm_campaign=%28direct%29&utm_content=undefined&utm_term=undefined&gclid=&_gl=1*146pj98*_gcl_au*MTYxOTMzODg0OS4xNzIxMjM3NzA5*_ga*NDkzMTU1NjI0LjE3MjEyMzc3MDk.*_ga_8Q7MD06RY0*MTcyMTMzMTE0MS43LjEuMTcyMTMzMTUwMC4yMC4wLjA.", "CANALES EXCLUSIVOS");

        // Términos y Condiciones
        webSite.scrollByPixels(Locators.scroll1Amount);
        webSite.desplegarTerminos();
        webSite.scrollByPixels(Locators.scrollAmount);
        String mensajeLegal = webSite.validarVencimiento();
        if (mensajeLegal.equals("Promoción válida desde el 01/07/2024 hasta el 31/07/2024 para clientes residenciales y Negocios (solo RUC 10). El beneficio consiste en un incremento de GB del plan Adicional S/ 39.90 a 120GB en alta velocidad (bono de 95GB en alta velocidad adicionales a los 25GB de la bolsa del plan).")) {
            System.out.println("Prueba exitosa: Se verificó el VENCIMIENTO LEGAL");
        } else {
            System.err.println("Prueba fallida: El legal esta vencido");
        }
        webSite.scrollByPixels(Locators.scroll2Amount);
        webSite.contraerTerminos();

        // Cintillo
        webSite.selectCintillo();
        webSite.formCintillo(celular, dni);
        webSite.registrarCintillo();
        String mensajeCintillo = webSite.validarPedido();
        if (mensajeCintillo.equals("¡Gracias por contactarnos!")) {
            System.out.println("Prueba exitosa: Se verificó el mensaje de confirmación CINTILLO");
        } else {
            System.out.println("Prueba fallida: El mensaje de confirmación no es el esperado");
        }
        webSite.closeModal();

        SetUp.closeDriver();
    }
}
