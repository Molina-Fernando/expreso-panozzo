package PDF;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;

public class GuiaPanozzoPDF {
    public static void main(String[] args) {
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("guia_encomienda_panozzo.pdf"));
            document.open();

            PdfContentByte canvas = writer.getDirectContent();

            Font titleFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Font boldFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
            Font regularFont = new Font(Font.FontFamily.HELVETICA, 9);

            // Encabezado
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("EXPRESO PANOZZO", titleFont), 40, 800, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("ENCOMIENDAS", boldFont), 40, 785, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("de Leites Silvia del Carmen", regularFont), 40, 770, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("Independencia 1197 esq. Irigoyen (3180) Federal E. Ríos", regularFont), 40, 755, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("Cel: 3454655395", regularFont), 40, 740, 0);

            // Datos guía y fecha
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("GUÍA", titleFont), 280, 800, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("Nº 00002749", regularFont), 450, 800, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("Fecha ___ / ___ / ______", regularFont), 450, 785, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("CUIT: 27-18376789-0", regularFont), 450, 770, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("Ing. Brutos: 27-18376789-0", regularFont), 450, 755, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("Inicio de Activ.: 23/05/2013", regularFont), 450, 740, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("DOCUMENTO NO VÁLIDO COMO FACTURA", boldFont), 450, 720, 0);

            // Campos Remitente / Destinatario
            float y = 700;
            String[] campos = {"Remitente:", "Domicilio:", "Localidad:"};
            for (String campo : campos) {
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(campo, regularFont), 40, y, 0);
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(campo.replace("e", "a"), regularFont), 280, y, 0); // espejo derecha
                y -= 20;
            }

            // Tabla
            canvas.rectangle(40, 200, 515, 400); // Marco
            canvas.moveTo(80, 200);
            canvas.lineTo(80, 600); // columna CANT.
            canvas.moveTo(495, 200);
            canvas.lineTo(495, 600); // columna PESO KG
            canvas.stroke();

            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("CANT.", boldFont), 45, 605, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("DESCRIPCIÓN", boldFont), 90, 605, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("PESO KG", boldFont), 500, 605, 0);

            // Valores declarados
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("VALOR DECLARADO $", regularFont), 40, 185, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("CONTRA REEMBOLSO $", regularFont), 250, 185, 0);
            canvas.moveTo(130, 182);
            canvas.lineTo(200, 182);
            canvas.moveTo(360, 182);
            canvas.lineTo(430, 182);
            canvas.stroke();

            // Seguro / Gestión / Presupuesto
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("Seguro", regularFont), 500, 185, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("Gestión Cobranza", regularFont), 500, 170, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("Presupuesto", regularFont), 500, 155, 0);

            // Texto legal
            String legalText = "Se requiere valor declarado de las cargas, caso contrario no nos responsabilizamos por avería, daño o pérdida que se produzcan "
                    + "como consecuencia de cualquier riesgo de transporte. La tenencia de este comprobante, no acredita el pago. Pasado los 30 días de la fecha "
                    + "de recepción de mercaderías, no se admitirán reclamos por las mismas, luego de 17º días de no ser retirada la mercadería se cobrará almacenaje "
                    + "en depósito, equivalente al 3% diario del valor del flete. Pagaré en los plazos convenidos el importe de esta Nota de Envío, la firma de este "
                    + "comprobante significa total conformidad de la mercadería sin reclamo alguno.";

            Paragraph parrafo = new Paragraph(legalText, new Font(Font.FontFamily.HELVETICA, 7));
            parrafo.setAlignment(Element.ALIGN_JUSTIFIED);
            parrafo.setSpacingBefore(10f);
            document.add(parrafo);

            // Pie
            ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, new Phrase("SE RECIBEN BULTOS IGNORANDO EL CONTENIDO", boldFont), 300, 80, 0);
            ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, new Phrase("SUJETO A DISPOSICIONES DEL CÓDIGO DE COMERCIO", boldFont), 300, 70, 0);
            canvas.moveTo(450, 50);
            canvas.lineTo(550, 50);
            canvas.stroke();
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("Firma y Aclaración", regularFont), 455, 40, 0);

            document.close();
            System.out.println("PDF generado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
