package poo.ufc;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class ControleWindow extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3970561829608143318L;

	Trem trem;
	
	public ControleWindow(final Trem trem) {
		this.trem = trem;
		
		 try {
	            // Set cross-platform Java L&F (also called "Metal")
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
		
		
		
		//adicionar passageiro
		JButton adicionarPassageiro = new JButton("Adicionar");
		adicionarPassageiro.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String nome;
				long cpf;
				try {
					nome = JOptionPane.showInputDialog("Digite o Nome do Usuário:");
					if(nome.isEmpty()){
						return;
					}
					cpf = Long.parseLong(JOptionPane.showInputDialog("Digite o CPF do Usuário:"));
					
				} catch (Exception e2) {
					return;
				}
				if(nome.isEmpty() || cpf == 0){
					JOptionPane.showInternalMessageDialog(null, "Erro ao Adicionar Passageiro");
				}
				Passageiro p = new Passageiro(nome, cpf);
				System.out.println(p.toString());
				if(trem.embarcar(p) == false){
					JOptionPane.showMessageDialog(null, "Não temos lugares o suficiente!!!\nAconselho esperar o trem possuir mais um vagão ou\n algum passageiro desembarcar...");
				};
			}
		});
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblPassageiro = new JLabel("PASSAGEIRO");
		lblPassageiro.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassageiro.setFont(new Font("Dialog", Font.BOLD, 19));
		add(lblPassageiro);
		
		JLabel lblTrem = new JLabel("TREM");
		lblTrem.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrem.setFont(new Font("Dialog", Font.BOLD, 19));
		add(lblTrem);
		add(adicionarPassageiro);
		
		
		
		//ver todos os passageiros
		JButton verTodosPassageitos = new JButton("Ver Todos");
		verTodosPassageitos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String pass = new String();
				for (Passageiro p : trem.getPassageiros()) {
					pass +=p.toString();
				}
				if(pass.isEmpty()){
					JOptionPane.showMessageDialog(null, "Nenhum Passageiro no Trem");
				}else{
					JOptionPane.showMessageDialog(null, pass);
				}
			}
		});
		
		
		//Acelerar Trem
		JButton acelerar = new JButton("Acelerar");
		acelerar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				trem.acelerar();
			}
		});
		
		
		
		//buscar passageiro
		JButton buscarPassageiro = new JButton("Buscar");
		buscarPassageiro.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				long cpf;
				try {
					cpf = Long.parseLong(JOptionPane.showInputDialog("Digite o CPF:"));
				} catch (Exception e2) {
					return;
				}
				Passageiro p = trem.buscar(cpf);
				if(p == null){
					
				}else{
					JOptionPane.showMessageDialog(null, p.toString());
				}
			}
		});
		
		
		//remove vagões do trem
		JButton removerVagoes = new JButton("Remover");
		removerVagoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quantidadeVagoes = String.valueOf(trem.getVagoes().size());
				int index;
				try {
					index = Integer.parseInt(JOptionPane.showInputDialog("Existe " + quantidadeVagoes + " Vagoes.\nEscolha um para Remover:"));
				} catch (Exception e2) {
					return;
				}
				if(Integer.parseInt(quantidadeVagoes) == 0){
					return;
				}
				if(trem.removerVagao(index-1) == false){
					JOptionPane.showMessageDialog(null, "Falha ao Remover Vagão");
				};
			}
		});
		
		
		//remover passageiro
		JButton removerPassageiro = new JButton("Remover");
		removerPassageiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long cpf;
				try {
					cpf = Long.parseLong(JOptionPane.showInputDialog("Digite o CPF para Desembarcarmos:"));
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "O CPF que você digitou é invalido");
					return;
				}
				trem.desembarcar(cpf);
			}
		});
		
		
		//adicionar vagões ao trem
		JButton adicionarVagoes = new JButton("Adicionar");
		adicionarVagoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int capacidade;
				try {
					capacidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a Capacidade Max do Vagão:"));			
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Por favor, digite uma numero e tente novamente...");
					return;
				}
				if(capacidade > 10)
					capacidade = 10;
				trem.adicionarVagao(new Vagao(capacidade));
			}
		});
		add(adicionarVagoes);
		add(removerPassageiro);
		add(removerVagoes);
		add(buscarPassageiro);
		add(acelerar);
		add(verTodosPassageitos);
		
		//Desacelerar trem
		JButton desacelerar = new JButton("Desacelerar");
		desacelerar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				trem.desacelerar();
			}
		});
		add(desacelerar);
		
		
		JButton removerTodos = new JButton("Remover Todos");
		removerTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trem.removerTodosPassageiros();
			}
		});
		add(removerTodos);
		
		//parar trem
		JButton parar = new JButton("Parar");
		parar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trem.parar();
			}
		});
		add(parar);

	}
	

}
