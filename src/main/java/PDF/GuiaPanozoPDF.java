package PDF;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.util.List;

public class GuiaPanozoPDF {

    public static class EncomiendaItem {

        public String descripcion;
        public int cantidad;
        public double peso;

        public EncomiendaItem(String descripcion, int cantidad, double peso) {
            this.descripcion = descripcion;
            this.cantidad = cantidad;
            this.peso = peso;
        }
    }

    public static void generarPDF(
            String nombreRemitente,
            String domicilioRemitente,
            String localidadRemitente,
            String nombreDestinatario,
            String domicilioDestinatario,
            String localidadDestinatario,
            String numeroGuia,
            String fecha,
            List<EncomiendaItem> items,
            double valorDeclarado,
            double reembolso,
            String rutaSalida
    ) throws Exception {

        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(rutaSalida));
        document.open();
        PdfContentByte cb = writer.getDirectContent();

     //   PdfContentByte cb = PdfWriter.getInstance(document, new FileOutputStream(rutaSalida)).getDirectContent();

        // Aquí podés copiar todo el código que genera la estructura,
        // y usar los parámetros en lugar de strings fijos.
        // Por ejemplo:
        document.add(new Paragraph("EXPRESO PANOZZO", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD)));
        document.add(new Paragraph("ENCOMIENDAS", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
        document.add(new Paragraph("de Leites Silvia del Carmen", new Font(Font.FontFamily.HELVETICA, 9)));
        document.add(new Paragraph("Independencia 1197 esq. Irigoyen (3180) Federal E. Ríos", new Font(Font.FontFamily.HELVETICA, 9)));
        document.add(new Paragraph("Cel: 3454655395", new Font(Font.FontFamily.HELVETICA, 9)));

        document.add(new Paragraph("GUÍA Nº " + numeroGuia + "  - Fecha: " + fecha));

        document.add(new Paragraph("Remitente: " + nombreRemitente));
        document.add(new Paragraph("Domicilio: " + domicilioRemitente));
        document.add(new Paragraph("Localidad: " + localidadRemitente));

        document.add(new Paragraph("Destinatario: " + nombreDestinatario));
        document.add(new Paragraph("Domicilio: " + domicilioDestinatario));
        document.add(new Paragraph("Localidad: " + localidadDestinatario));

        document.add(new Paragraph(" ")); // espacio

        PdfPTable table = new PdfPTable(new float[]{1, 5, 2});
        table.setWidthPercentage(100);
        table.addCell("CANT.");
        table.addCell("DESCRIPCIÓN");
        table.addCell("PESO");

        for (EncomiendaItem item : items) {
            table.addCell(String.valueOf(item.cantidad));
            table.addCell(item.descripcion);
            table.addCell(String.valueOf(item.peso));
        }

        document.add(table);

        document.add(new Paragraph("Valor declarado: $" + valorDeclarado));
        document.add(new Paragraph("Contra reembolso: $" + reembolso));

        // Podés agregar más campos como quieras acá
        document.close();
    }
}
