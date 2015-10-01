/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mvn.dispositivo;

import mvn.Bits8;
import mvn.Dispositivo;
import mvn.controle.MVNException;

/**
 *
 * @author mjunior
 */
public class Fibonacci implements Dispositivo {
    private  Bits8 v0, v1;
    
    public Fibonacci () {
    	this.v0 = new Bits8(0);
    	this.v1 = new Bits8(0);
    }

	@Override
	public void escrever(Bits8 in) throws MVNException {
		v0 = v1;
		v1 = in;
	}

	@Override
	public Bits8 ler() throws MVNException {
		v1.add(v0);
		escrever(v1);
		return v1;
	}

	@Override
	public boolean podeLer() {
		return true;
	}

	@Override
	public boolean podeEscrever() {
		return true;
	}

	@Override
	public void reset() {
		v1 = new Bits8(0);
		v0 = new Bits8(0);
	}

	@Override
	public Bits8 skip(Bits8 val) throws MVNException {
		for(int i=0; i<val.toInt(); i++) {
			ler();
		}
		return ler();
	}

	@Override
	public Bits8 position() {
		return v0;
	}

	@Override
	public Bits8 size() {
		return v1;
	}
}
