package poo.ufc;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;




public class ControleWindow extends JFrame {
	
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
				Passageiro p;
				int tipoPassageiro;
				try{
					tipoPassageiro = Controlador.opcaoPassageiro();
				}catch(Exception e1){
					return;
				}
				
				if(tipoPassageiro == -1){
					return;
				}
				if(tipoPassageiro == 1 || tipoPassageiro == 3){
					String nome;
					long cpf;
					int frescura = 0;
					try {
						nome = JOptionPane.showInputDialog("Digite o Nome do Usuário:");
						cpf = Long.parseLong(JOptionPane.showInputDialog("Digite o CPF do Usuário:"));
						if(nome.isEmpty() || cpf == 0){
							JOptionPane.showInternalMessageDialog(null, "Erro ao Adicionar Passageiro");
							return;
						}
						if(tipoPassageiro == 3){
							frescura = Integer.parseInt(JOptionPane.showInputDialog("Digite o nivel de frescura:"));
						}
						
					} catch (Exception e2) {
						return;
					}
					if(tipoPassageiro == 3){
						p = (Pessoa) (new Fresca(nome, cpf, frescura)); 
					}else{
						p = new Pessoa(nome, cpf);
					}
						System.out.println(p.toString());
				}else{
					String especie;
					int peso;
					try {
						especie = JOptionPane.showInputDialog("Digite a especie do animal");
						peso = Integer.parseInt((JOptionPane.showInputDialog("Digite o peso do animal:")));
						if(especie.isEmpty()){
							return;
						}
						
					} catch (Exception e2) {
						return;
					}
					if(especie.isEmpty() || peso == 0){
					}
						p = new Animal(0, especie, peso);
						System.out.println(p.toString());
				}
				
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
				String quantidadeVagoes = String.valueOf(trem.getQuantVagoes());
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
				int opcao = Controlador.opcaoVagao();
				if(opcao == -1){
					return;
				}
				
				int capacidade;
				if(opcao == 1){
					try {
						capacidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a Capacidade Max de passageiros que o vagao suporta:"));			
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Por favor, digite uma numero e tente novamente...");
						return;
					}
					if(capacidade > 10)
						capacidade = 10;
					trem.adicionarVagao(new VagaoPessoa(capacidade), 1);
				}else if(opcao == 2){
					try {
						capacidade = Integer.parseInt(JOptionPane.showInputDialog("Digite o Peso maximo que o vagao pode suportar:"));			
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Por favor, digite uma numero e tente novamente...");
						return;
					}
					trem.adicionarVagao(new VagaoAnimal(capacidade), 2);
				}
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
		
		//teclado

	}

}
