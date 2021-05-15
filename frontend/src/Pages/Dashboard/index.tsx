import BarCharts from "componentes/BarCharts";
import BarChartDiary from "componentes/BarCharts/BarChartDiary";
import DataTable from "componentes/DataTable";
import Footer from "componentes/Footer";
import NavBar from "componentes/NavBar";

function Dashboard() {
    return (
        <>
            <div>
                <NavBar />
            </div>
            <div className="container">
                <h1 className="text-primary py-3">Ranking MVP</h1>
                <div className="row px-3">
                    <div className="col sm-5">
                        <h5 className='text-center text-secundary'>Top 5 Geral</h5>
                        <BarCharts />
                    </div>
                    <div className="col sm-5">
                        <h5 className='text-center text-secundary'>Top 5 Diário</h5>
                        <BarChartDiary /></div>
                    <div className='py-3'>
                        <h2 className='text-primary'>Histórico</h2>
                    </div>
                </div>
                <DataTable />
            </div>
            <Footer />
        </>
    );
}
export default Dashboard;