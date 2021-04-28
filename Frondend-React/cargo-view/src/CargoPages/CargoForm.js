import React from 'react';
import axios from 'axios';
import '../Mycss.css';

// CargoFrom isminde component sınıfı oluşturuldu.

class CargoForm extends React.Component {

    // Component sınıfı içerisinde kullanılacak değişkenler oluşturuldu.
    state = {

        sevenCount: null,
        twoCount: null,
        totalKg: null,
        message: null


    };

    // Form içerisinde girilen input değerlerinin state içerisinde oluşturulmuş
    // değişkenlere ataması yapıldı.
    onChange = event => {

        const value = event.target.value
        const names = event.target.name

        this.setState({

            [names]: value

        });

    };



    // Form içerisinde onClick olayı ile tetiklenen PostKargo methodunun oluşturulması.
    PostKargo = event => {


        event.preventDefault();
        // Daha önce kullanıcıdan alınıp state içerisindeki değişkenlere
        // aktarılmış verilerin Json formatına dönüştürülmesi 
        const body = {

            sevenCount: this.state.sevenCount,
            twoCount: this.state.twoCount,
            totalKg: this.state.totalKg

        }

        // Axios kütüphanesi sayesinde elimizdeki verinin backende taşınması(Post edilmesi)
        // ve backenden dönen veriye göre kullanıcıya gerekli dönüşün sağlanması.
        axios.post('http://localhost:8080/api/1.0/cargo', body)
            .then(response => {
                if (response.data === -1) {
                    this.setState({ message: "İşlem sağlanamaz." });
                } else {
                    this.setState({ message: response.data + " adet 2 kg lık paket gerekli." });
                }
            })




    }



    render() {
        return (

            // Bootstrap teknolojisi kullanılarak kullanıcıya sunulacak arayüzün oluşturulması
            <div id="wrapper">
                <div className="container">
                    <form>

                        <h3 className="text-center">Kargo Hesaplama Ekranı</h3>


                        <div className="form-group">
                            <label >7 kiloluk paket adedi</label>
                            <input type="text" name="sevenCount" className="form-control"

                                onChange={this.onChange}

                            />
                        </div>

                        <div className="form-group">
                            <label >2 kiloluk paket adeti</label>
                            <input type="text" name="twoCount" className="form-control"

                                onChange={this.onChange}


                            />
                        </div>

                        <div className="form-group">
                            <label >Toplam paket kilosu</label>
                            <input type="text" name="totalKg" className="form-control"

                                onChange={this.onChange}


                            />
                        </div>

                        <div className="text-center">
                            <button class="btn btn-primary" type="submit" onClick={this.PostKargo}>Hesapla</button>
                        </div>
                    </form>



                    <div> {this.state.message} </div>
                </div>
            </div>

        )
    }


}

export default CargoForm;