package org.abc.utils;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Map;

import org.zkoss.util.media.AMedia;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleCsvMetadataReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;

public class GenerarReporte {
	public AMedia generarReporte(URL reportPath, String format, Map parameters, Connection connection)
			throws JRException, SQLException {
		Locale locale = new Locale("es", "BO");
		parameters.put(JRParameter.REPORT_LOCALE, locale);
		byte[] rep = generarReporte2(reportPath, format, parameters, connection);
		AMedia amedia = new AMedia("document", format, null, rep);
		return amedia;
	}

	public byte[] generarReporte2(URL reportPath, String format, Map<?, ?> parameters, Connection connection)
			throws JRException, SQLException {
		JasperReport report2 = (JasperReport) JRLoader.loadObject(reportPath);

		JasperPrint fill = JasperFillManager.fillReport(report2, (Map<String, Object>) parameters, connection);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		if (format.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfStream(fill, out);
		} else if (format.equalsIgnoreCase("csv")) {
			JRCsvExporter exporter = new JRCsvExporter();
			SimpleCsvMetadataReportConfiguration configuration = new SimpleCsvMetadataReportConfiguration();
			exporter.setExporterInput(new SimpleExporterInput(fill));
			exporter.setExporterOutput(new SimpleWriterExporterOutput(out));
			exporter.setConfiguration(configuration);
			exporter.exportReport();
		} else if (format.equalsIgnoreCase("xls")) {
			JRXlsExporter exporter = new JRXlsExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, fill);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
			exporter.exportReport();
		} else if (format.equalsIgnoreCase("html")) {
			JRHtmlExporter exporter = new JRHtmlExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, fill);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
            exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
			exporter.exportReport();
		} else if (format.equals("rtf")) {
			JRRtfExporter exporter = new JRRtfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, fill);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
			exporter.exportReport();
		} else if (format.equals("txt")) {
			Map<?, ?> txt_formatoparams = (Map<?, ?>) parameters.get("TXT_FORMATO_PARAMS");
			JRExporter exporter = new JRTextExporter();
			Integer pageHeight = new Integer(fill.getPageHeight());
			Integer pageWidth = new Integer(fill.getPageWidth());
			exporter.setParameter(JRTextExporterParameter.JASPER_PRINT, fill);
			exporter.setParameter(JRTextExporterParameter.OUTPUT_STREAM, out);
			if (txt_formatoparams != null) {
				exporter.setParameter(JRTextExporterParameter.PAGE_WIDTH,
						txt_formatoparams.get(JRTextExporterParameter.PAGE_WIDTH));
				exporter.setParameter(JRTextExporterParameter.PAGE_HEIGHT,
						txt_formatoparams.get(JRTextExporterParameter.PAGE_HEIGHT));
				exporter.setParameter(JRTextExporterParameter.CHARACTER_WIDTH,
						txt_formatoparams.get(JRTextExporterParameter.CHARACTER_WIDTH));
				exporter.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT,
						txt_formatoparams.get(JRTextExporterParameter.CHARACTER_HEIGHT));
				// exporter.setParameter(JRTextExporterParameter.BETWEEN_PAGES_TEXT,
				// txt_formatoparams.get(JRTextExporterParameter.BETWEEN_PAGES_TEXT));
				exporter.setParameter(JRTextExporterParameter.LINE_SEPARATOR,
						txt_formatoparams.get(JRTextExporterParameter.LINE_SEPARATOR));
			}
			exporter.exportReport();
		}
		return out.toByteArray();
	}
}
