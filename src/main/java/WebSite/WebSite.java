package WebSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class WebSite {

    private static WebDriver driver;

    public WebSite(WebDriver driver) {
        WebSite.driver = driver;
    }

    public void navigateToWebsite(String url) throws InterruptedException {
        driver.get(url);

        // Use WebDriverWait para espera explícita (recomendado)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));  // Espere la carga básica de la página
    }

    // Navegación Form 20% DTO
    public void validate20DTO(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.polm1Link).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
    }

    public void selectLegal20DTO() throws InterruptedException {
        driver.findElement(Locators.deselm1Box).click();
        Thread.sleep(500);
        driver.findElement(Locators.selm1Box).click();
        Thread.sleep(500);
        driver.findElement(Locators.promm1Link).click();
        Thread.sleep(1000);
        driver.findElement(Locators.promm1Cerrar).click();
        Thread.sleep(1000);
    }

    public void inputFormulatio20DTO(String celular, String dni) {
        driver.findElement(Locators.inputm1Celular).sendKeys(celular);
        driver.findElement(Locators.inputm1DNI).sendKeys(dni);
    }

    public static void selectHorario20DTO(String horario) throws InterruptedException {
        Select agendamientoFechaSelect = new Select(driver.findElement(Locators.agendamientom1FechaCombo));
        agendamientoFechaSelect.selectByValue(horario);
        Thread.sleep(1000);
    }

    public void submitPedido20DTO() throws InterruptedException {
        driver.findElement(Locators.registrarm1Button).click();
        Thread.sleep(5000);
    }

    public String validatePedido20STO() {
        return driver.findElement(Locators.confirmationm1Message).getText();
    }

    public void closeModal20DTO() throws InterruptedException {
        driver.findElement(Locators.cerrarm1Message).click();
        Thread.sleep(1000);
    }

    // Navegación Form DELIVERY
    public void validateTerminosDelivery(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.terminosLink).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
    }

    public void openFormularioDelivery() throws InterruptedException {
        driver.findElement(Locators.formularioButton).click();
        Thread.sleep(2000);
    }

    public void validatePoliticas(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.politicasLink).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
    }

    public void selectPromNove() throws InterruptedException {
        WebElement checkboxBeforeElement = driver.findElement(Locators.deselpm2Box);  // Localizar el elemento con ::before
        // Cast driver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Simular clic usando JavaScript
        js.executeScript("arguments[0].click();", checkboxBeforeElement);
        Thread.sleep(1000);
        WebElement checkbox2BeforeElement = driver.findElement(Locators.selpm2Box);  // Localizar el elemento con ::before
        // Cast driver to JavascriptExecutor
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        // Simular clic usando JavaScript
        js2.executeScript("arguments[0].click();", checkbox2BeforeElement);
        Thread.sleep(1000);
        //driver.findElement(Locators.promm2Link).click();
        //Thread.sleep(2000);
        //driver.findElement(Locators.promm2Cerrar).click();
        //Thread.sleep(2000);
    }

    public void selectRestricciones() throws InterruptedException {
        WebElement checkboxBeforeElement = driver.findElement(Locators.deselrm2Box);  // Localizar el elemento con ::before
        // Cast driver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Simular clic usando JavaScript
        js.executeScript("arguments[0].click();", checkboxBeforeElement);
        Thread.sleep(1000);
        WebElement checkbox2BeforeElement = driver.findElement(Locators.selrm2Box);  // Localizar el elemento con ::before
        // Cast driver to JavascriptExecutor
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        // Simular clic usando JavaScript
        js2.executeScript("arguments[0].click();", checkbox2BeforeElement);
        Thread.sleep(1000);
        //driver.findElement(Locators.restm2Link).click();
        //Thread.sleep(2000);
        //driver.findElement(Locators.restm2Cerrar).click();
        //Thread.sleep(2000);
    }

    public void inputFormulario(String celular, String dni) {
        driver.findElement(Locators.inputm2DNI).sendKeys(dni);
        driver.findElement(Locators.inputm2Celular).sendKeys(celular);
    }

    public static void selectHorario(String horario) throws InterruptedException {
        Select agendamientoFechaSelect = new Select(driver.findElement(Locators.agendamientom2FechaCombo));
        agendamientoFechaSelect.selectByValue(horario);
        Thread.sleep(1000);
    }

    public void submitPedido() throws InterruptedException {
        driver.findElement(Locators.registrarm2Button).click();
        Thread.sleep(5000);
    }

    public String validarPedido() {
        return driver.findElement(Locators.confirmationm2Message).getText();
    }

    public void closeModal() throws InterruptedException {
        driver.findElement(Locators.cerrarm2Message).click();
        Thread.sleep(1000);
    }

    public void closeModalDelivery() throws InterruptedException{
        driver.findElement(Locators.cerrarm2Delivery).click();
        Thread.sleep(2000);
    }

    // Navegación BANNER
    public void cerrarModales() throws InterruptedException {
        driver.findElement(Locators.cerrarM20Modal).click();
        Thread.sleep(5000);
        driver.findElement(Locators.cerrarMDeModal).click();
        Thread.sleep(5000);
    }

    public void selecB1Bullet(int index) throws InterruptedException {
        driver.findElement(Locators.getBullet(index)).click();
        Thread.sleep(5000);
    }

    public void validatePoliticasBanner(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.politicasbannerLink).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
    }

    public void selectPromNoveBanner() throws InterruptedException {
        WebElement checkboxBeforeElement = driver.findElement(Locators.deselb1Box);  // Localizar el elemento con ::before
        // Cast driver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Simular clic usando JavaScript
        js.executeScript("arguments[0].click();", checkboxBeforeElement);
        Thread.sleep(1000);
        WebElement checkbox2BeforeElement = driver.findElement(Locators.selb1Box);  // Localizar el elemento con ::before
        // Cast driver to JavascriptExecutor
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        // Simular clic usando JavaScript
        js2.executeScript("arguments[0].click();", checkbox2BeforeElement);
        Thread.sleep(1000);
        //driver.findElement(Locators.promb1Link).click();
        //Thread.sleep(3000);
        //driver.findElement(Locators.promb1Cerrar).click();
        //Thread.sleep(1000);
    }

    public void inputFormularioBanner(String celular, String dni) {
        driver.findElement(Locators.inputb1Celular).sendKeys(celular);
        driver.findElement(Locators.inputb1DNI).sendKeys(dni);
    }

    public static void selectHorarioBanner(String horario) throws InterruptedException {
        Select agendamientoFechaSelect = new Select(driver.findElement(Locators.agendamientob1FechaCombo));
        agendamientoFechaSelect.selectByValue(horario);
        Thread.sleep(2000);
    }

    public void submitPedidoBanner() throws InterruptedException {
        driver.findElement(Locators.registrarb1Button).click();
        Thread.sleep(5000);
    }

    // Scroll
    public void scrollByPixels(int amount) throws InterruptedException {
        // Desplazar la ventana verticalmente por la cantidad especificada
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + amount + ")");
        Thread.sleep(5000);
    }

    public void scroll2ByPixels(int amount) throws InterruptedException {
        // Desplazar la ventana verticalmente por la cantidad especificada
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -" + amount + ")");
        Thread.sleep(5000);
    }

    // Sección Equipos + Plan Contodo
    public void openFormularioContodo() throws InterruptedException {
        driver.findElement(Locators.openformularioCTButton).click();
        Thread.sleep(5000);
    }

    // Sección Equipos + Plan EQUIPOS
    public void selectMarca() throws InterruptedException {
        driver.findElement(Locators.marcaSelect).click();
        Thread.sleep(3000);
    }

    public void openFormularioEquipos() throws InterruptedException {
        driver.findElement(Locators.openformularioEButton).click();
        Thread.sleep(5000);
    }

    // File Equipos Sin Plan
    public void selectEquiposSinplan() throws InterruptedException{
        driver.findElement(Locators.sinplanSelect).click();
        Thread.sleep(1000);
    }

    public void validateLoquiero(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.loquieroLink).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
        Thread.sleep(1000);
    }

    // File Solo Plan
    public void selectSoloplan() throws InterruptedException{
        driver.findElement(Locators.soloplanSelect).click();
        Thread.sleep(2000);
    }

    public void selectdetalleSoloplan() throws InterruptedException{
        driver.findElement((Locators.desplegarSPSelect)).click();
        Thread.sleep(1000);
        driver.findElement((Locators.ocultarSPSelect)).click();
        Thread.sleep(1000);
    }

    public void clickEquipolinea() throws InterruptedException{
        driver.findElement((Locators.equipolineaClick)).click();
        Thread.sleep(1000);
    }

    public void abrir2M5EnlaceEnNuevaVentana(String url) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle(); // Obtener el identificador de ventana actual
        driver.findElement(Locators.polm4Link).click(); // Click en el enlace Políticas
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Tiempo máximo de espera (10)
        wait.until(ExpectedConditions.numberOfWindowsToBe(3)); // Cantidad de páginas (2)
        // Validar que la URL nueva sea igual al Enlace
        for (String handle : driver.getWindowHandles()) {
            if (handle.equals(handlePaginaActual)) {  // Si deseas pasar a la nueva ventana agrear el signo de admiración "!" antes de handle.equals
                driver.switchTo().window(handle);
                break;
            }
        }
        Thread.sleep(5000);
    }

    public void clickLinea() throws InterruptedException{
        driver.findElement((Locators.lineaClick)).click();
        Thread.sleep(1000);
    }

    // Promociones
    public void clickPromociones() throws InterruptedException{
        driver.findElement((Locators.solicitaaquiClick)).click();
        Thread.sleep(1000);
    }

    // Recomendado
    public void clickRecomendado() throws InterruptedException{
        driver.findElement((Locators.recomendadoClick)).click();
        Thread.sleep(1000);
    }

    // Cambiate
    public void validateVerofertas(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.verofertasClick).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
    }

    // Beneficios
    public void validateMovistartv(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.clickMovistartv).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
    }

    public void validateSmartwifi(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.clickSmartwifi).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
    }

    public void validateExclusivos(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.clickExclusivos).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
    }

    // Términos y Condiciones
    public void desplegarTerminos() throws InterruptedException{
        driver.findElement(Locators.clickaTerminos).click();
        Thread.sleep(1000);
    }

    public String validarVencimiento() {
        return driver.findElement(Locators.validarLegal).getText();
    }

    public void contraerTerminos() throws InterruptedException{
        driver.findElement(Locators.clickcTerminos).click();
        Thread.sleep(1000);
    }

    // Cintillo
    public void selectCintillo() throws InterruptedException {
        WebElement checkboxBeforeElement = driver.findElement(Locators.quitarTratamientos);  // Localizar el elemento con ::before
        // Cast driver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Simular clic usando JavaScript
        js.executeScript("arguments[0].click();", checkboxBeforeElement);
        Thread.sleep(1000);
        WebElement checkbox2BeforeElement = driver.findElement(Locators.agregarTratamientos);  // Localizar el elemento con ::before
        // Cast driver to JavascriptExecutor
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        // Simular clic usando JavaScript
        js2.executeScript("arguments[0].click();", checkbox2BeforeElement);
        Thread.sleep(1000);
        //driver.findElement(Locators.clickTratamientos).click();
        //Thread.sleep(1000);
        //driver.findElement(Locators.cerrarTratamientos).click();
        //Thread.sleep(1000);
    }

    public void formCintillo(String celular, String dni) {
        driver.findElement(Locators.cintilloDNI).sendKeys(dni);
        driver.findElement(Locators.cintilloCelular).sendKeys(celular);
    }

    public void registrarCintillo() throws InterruptedException{
        driver.findElement(Locators.clickrCintillo).click();
        Thread.sleep(3000);
    }
}
