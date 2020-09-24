package org.abc.viewmodel;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.abc.domain.ReportType;
import org.abc.utils.GenerarReporte;
import org.abc.utils.Parametros;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Iframe;

import net.sf.jasperreports.engine.JRException;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ReportVM {
	private final static Logger logger = LoggerFactory.getLogger(ReportVM.class);

	Date fecInicio;
	Date fecFin;
	List<ReportType> formatosReporte;
	ReportType formatoReporte;
	@WireVariable
	private BasicDataSource empDS;
	
	@Wire("#ifrmReporte")
	private Iframe ifrmReporte;
//	@Wire("#reportePage")
//	private Window reportePage;
	
	@AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
        Selectors.wireComponents(view, this, false);
    }
	
	@Init
	public void init() {
		formatosReporte=Parametros.getFormatosReporte();
		fecFin=Parametros.getFechaActual();
		fecInicio=Parametros.getSumasDiasFecha(fecFin, Parametros.DIAS_VENTA);
		formatoReporte=formatosReporte.get(0);
	}
	
	@Command
	public void verReporte() throws JRException, SQLException {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("fec_inicio", fecInicio);
		map.put("fec_fin", fecFin);
		String reportPath=Parametros.PATH_REPORTES+"report.jasper";
		AMedia media = new GenerarReporte().generarReporte(getClass().getResource(reportPath), formatoReporte.getValue(), map, empDS.getConnection());
		ifrmReporte.setContent(media);
	}
	
	public Date getFecInicio() {
		return fecInicio;
	}

	public void setFecInicio(Date fecInicio) {
		this.fecInicio = fecInicio;
	}

	public Date getFecFin() {
		return fecFin;
	}

	public void setFecFin(Date fecFin) {
		this.fecFin = fecFin;
	}

	public List<ReportType> getFormatosReporte() {
		return formatosReporte;
	}

	public BasicDataSource getEmpDS() {
		return empDS;
	}

	public void setEmpDS(BasicDataSource empDS) {
		this.empDS = empDS;
	}

	public ReportType getFormatoReporte() {
		return formatoReporte;
	}

	public void setFormatoReporte(ReportType formatoReporte) {
		this.formatoReporte = formatoReporte;
	}
	
	
}
