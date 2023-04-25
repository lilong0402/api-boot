<template>
  <div class="echart" id="mychart" :style="myChartStyle"></div>
</template>

<script>
import * as echarts from 'echarts'

export default {
  data() {
    return {
      myChart: {},
      pieData: [
        {
          value: 51,
          name: '24'
        },
        {
          value: 51,
          name: '23'
        },
        {
          value: 10,
          name: '22'
        },
        {
          value: 11,
          name: '21'
        },
        {
          value: 31,
          name: '20'
        },
        {
          value: 20,
          name: '19'
        },
        {
          value: 22,
          name: '18'
        }
      ],
      pieName: [],
      myChartStyle: { float: 'left', width: '100%', height: '400px' } //图表样式
    }
  },
  mounted() {
    this.initDate() //数据初始化
    this.initEcharts()
  },
  methods: {
    initDate() {
      for (let i = 0; i < this.pieData.length; i++) {
        // this.xData[i] = i;
        // this.yData =this.xData[i]*this.xData[i];
        this.pieName[i] = this.pieData[i].name
      }
    },
    initEcharts() {
      // 饼图
      const option = {
        legend: {
          // 图例
          data: this.pieName,
          right: '10%',
          top: '30%',
          orient: 'vertical'
        },
        title: {
          // 设置饼图标题，位置设为顶部居中
          text: '近一周订单',
          top: '10%',
          left: 'center'
        },
        series: [
          {
            type: 'pie',
            label: {
              show: true
              //   formatter: '{c} ({d}%)' // b代表名称，c代表对应值，d代表百分比
            },
            radius: '30%', //饼图半径
            data: this.pieData,
            showBackground: true,
            backgroundStyle: {
              color: 'rgba(180, 180, 180, 0.2)'
            }
          }
        ]
      }
      console.log(this.seriesData)
      const optionFree = {
        xAxis: {},
        yAxis: {},
        series: [
          {
            data: this.seriesData,
            type: 'line',
            smooth: true
          }
        ]
      }
      this.myChart = echarts.init(document.getElementById('mychart'))
      this.myChart.setOption(option)
      //随着屏幕大小调节图表
      window.addEventListener('resize', () => {
        this.myChart.resize()
      })
    }
  }
}
</script>
