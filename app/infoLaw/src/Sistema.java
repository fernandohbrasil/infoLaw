
import controller.PrincipalController;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Sistema {

    public static void main(String[] args) throws JRException, SQLException {

//        Map<String, Object> parametros = new HashMap<String, Object>();
//        Connection connexao = new Conexao().getFirebid();

        /*
        int id = /;
        parametros.put("id", id);  
        
        
        //JasperFillManager.fillReport("contas_em_aberto.jasper", parametros, connexao);            
        // preencher o relatório utilizando a conexão do banco de dados
        JasperPrint relatorio = JasperFillManager.fillReport("contas_em_aberto.jasper", parametros, connexao);

        // exibindo o relatório
        JasperViewer.viewReport(relatorio, false);
        connexao.close();
                        */
        PrincipalController principalControle = new PrincipalController();
        principalControle.executar();
    }
}